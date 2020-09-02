package com.nokey.vtmcompanion

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nokey.vtmcompanion.data.Character
import com.nokey.vtmcompanion.data.CharacterManager
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Rule
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.rules.TestRule
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException


internal class SplashScreenViewModelTest : JUnit5Test() {
    @Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var characterManager: CharacterManager

    private lateinit var subject: SplashScreenViewModel

    @BeforeAll
    fun setup() {
        subject = SplashScreenViewModel(characterManager)
    }

    @Test
    fun characterPresent_goToCharacterSheet() {
        val character = mockk<Character>()
        every { characterManager.getCharacter() } returns MutableLiveData(character)

        val hasCharacter = subject.checkForCharacter().getOrAwaitValue()

        assert(hasCharacter)
    }

    @Test
    fun characterNull_goToCharacterCreation() {
        every { characterManager.getCharacter() } returns MutableLiveData(null)

        val characterMissing = !subject.checkForCharacter().getOrAwaitValue()

        assert(characterMissing)
    }
}

fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(o: T?) {
            data = o
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }

    this.observeForever(observer)

    // Don't wait indefinitely if the LiveData is not set.
    if (!latch.await(time, timeUnit)) {
        throw TimeoutException("LiveData value was never set.")
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}