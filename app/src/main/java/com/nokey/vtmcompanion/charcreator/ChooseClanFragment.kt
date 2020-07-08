package com.nokey.vtmcompanion.charcreator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nokey.vtmcompanion.databinding.FragmentChooseClanBinding

class ChooseClanFragment : Fragment() {
    private lateinit var binding: FragmentChooseClanBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseClanBinding.inflate(inflater, container, false)
        binding.clanSelectionRecycler.adapter = ClanSelectionAdapter()
        return binding.root
    }
}