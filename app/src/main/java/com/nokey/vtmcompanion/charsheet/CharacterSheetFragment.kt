package com.nokey.vtmcompanion.charsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import com.nokey.vtmcompanion.DaggerNavigationFragment
import com.nokey.vtmcompanion.R
import com.nokey.vtmcompanion.databinding.FragmentCharacterSheetBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CharacterSheetFragment : DaggerNavigationFragment<FragmentCharacterSheetBinding>() {
    private val adapter = AttributeDotsAdapter()
    private val viewModel by navGraphViewModels<CharacterSheetViewModel>(R.id.character_sheet) {
        defaultViewModelProviderFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterSheetBinding.inflate(layoutInflater, container, false).also {
            it.attributeView.adapter = adapter
            init()
        }

        return binding?.root
    }

    private fun init() {
        Timber.d("Getting Character From Database")
        viewModel.getCharacter().observe(viewLifecycleOwner, Observer { character ->
            Timber.d("Retrieved $character")
            adapter.setAttributes(character.attributes.sortedBy { it.attributeType }.toList())
        })
    }
}