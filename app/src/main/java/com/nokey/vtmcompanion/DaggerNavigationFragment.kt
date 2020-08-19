package com.nokey.vtmcompanion

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import javax.inject.Inject

abstract class DaggerNavigationFragment<VB> : Fragment() {

    protected var binding: VB? = null

    protected fun NavDirections.navigate() {
        findNavController().navigate(this)
    }
}