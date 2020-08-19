package com.nokey.vtmcompanion.charcreator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.nokey.vtmcompanion.DaggerNavigationFragment
import com.nokey.vtmcompanion.R
import com.nokey.vtmcompanion.data.Clan
import com.nokey.vtmcompanion.databinding.FragmentChooseClanBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChooseClanFragment : DaggerNavigationFragment<FragmentChooseClanBinding>() {
    private val viewModel by navGraphViewModels<CharacterCreationViewModel>(R.id.char_creation_graph) {
        defaultViewModelProviderFactory
    }

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

    private fun onClanClicked(clan: Clan) {
        viewModel.selectedClan = clan
        ChooseClanFragmentDirections.actionChooseClanToNameSire().navigate()
    }
}
