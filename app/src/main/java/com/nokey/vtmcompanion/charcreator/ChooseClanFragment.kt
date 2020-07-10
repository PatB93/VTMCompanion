package com.nokey.vtmcompanion.charcreator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nokey.vtmcompanion.NavigationFragment
import com.nokey.vtmcompanion.data.Clans
import com.nokey.vtmcompanion.databinding.FragmentChooseClanBinding

class ChooseClanFragment : NavigationFragment<FragmentChooseClanBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseClanBinding.inflate(inflater, container, false).apply {
            clanSelectionRecycler.adapter = ClanSelectionAdapter(::onClanClicked)
        }
        return binding?.root
    }

    private fun onClanClicked(clan: Clans) {
        ChooseClanFragmentDirections.actionChooseClanToNameSire().navigate()
    }
}