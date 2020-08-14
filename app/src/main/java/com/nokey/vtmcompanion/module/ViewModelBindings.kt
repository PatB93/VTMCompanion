package com.nokey.vtmcompanion.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nokey.vtmcompanion.charcreator.CharacterCreationViewModel
import com.nokey.vtmcompanion.ext.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(FragmentComponent::class)
abstract class ViewModelBindings {
    @Binds
    @IntoMap
    @ViewModelKey(CharacterCreationViewModel::class)
    abstract fun characterCreationViewModel(createViewModel: CharacterCreationViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}