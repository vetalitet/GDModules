package com.vetalitet.ui.features.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vetalitet.themes.ThemeProvider
import com.vetalitet.ui.databinding.FragmentMainBinding
import com.vetalitet.ui.di.setup.LibKoinComponent
import com.vetalitet.ui.features.BaseFragment
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class MainFragment: BaseFragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.theme = ThemeProvider.currentTheme.value
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

}
