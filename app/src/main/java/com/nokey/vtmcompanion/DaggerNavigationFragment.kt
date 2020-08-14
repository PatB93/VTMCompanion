package com.nokey.vtmcompanion

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.nokey.vtmcompanion.ext.ViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

abstract class DaggerNavigationFragment<VB> : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    protected var binding: VB? = null

    protected fun NavDirections.navigate() {
        findNavController().navigate(this)
    }
}