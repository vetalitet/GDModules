package com.vetalitet.ui.features.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.vetalitet.themes.ThemeProvider
import com.vetalitet.ui.R
import com.vetalitet.ui.core.UiState
import com.vetalitet.ui.databinding.FragmentLoginBinding
import com.vetalitet.ui.di.setup.LibKoinComponent
import com.vetalitet.ui.features.BaseFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class LoginFragment : BaseFragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModel<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.theme = ThemeProvider.currentTheme.value
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTheme()
        setupHandlers()
    }

    private fun setupTheme() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                ThemeProvider.currentTheme.collect {
                    binding.invalidateAll()
                }
            }
        }
    }

    private fun setupHandlers() {
        viewModel.loginLiveData.observe(viewLifecycleOwner, {
            if (it is UiState.Success<*>) {
                val value = (it as UiState.Success<String>).result
                findNavController().navigate(R.id.mainFragment)
            }
        })
        viewModel.apiIDLiveData.observe(viewLifecycleOwner, {
            Toast.makeText(requireContext(), "Injected object: $it", Toast.LENGTH_LONG).show()
        })
    }

}
