package com.nokey.vtmcompanion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.nokey.vtmcompanion.databinding.FragmentSplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashScreenFragment : DaggerNavigationFragment<FragmentSplashScreenBinding>() {

    private val viewModel by viewModels<SplashScreenViewModel>() { defaultViewModelProviderFactory }

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
            viewModel.checkForCharacter()
                .observe(viewLifecycleOwner, Observer { characterAlreadyExists ->
                    if (characterAlreadyExists) {
                        SplashScreenFragmentDirections.actionSplashScreenCharacterSheet().navigate()
                    } else {
                        SplashScreenFragmentDirections.actionSplashScreenToChooseClan().navigate()
                    }
                })
        }
    }
}
