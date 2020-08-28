package com.nokey.vtmcompanion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.nokey.vtmcompanion.databinding.FragmentSplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenFragment : DaggerNavigationFragment<FragmentSplashScreenBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        startSplashScreenTimer()
        return binding?.root
    }

    private fun startSplashScreenTimer() {
        lifecycleScope.launch {
            delay(2000L)
            SplashScreenFragmentDirections.actionSplashScreenToChooseClan().navigate()
        }
    }
}
