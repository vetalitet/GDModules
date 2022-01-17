package com.vetalitet.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.vetalitet.themes.ThemeProvider
import com.vetalitet.ui.core.UiState
import com.vetalitet.ui.databinding.FragmentLoginBinding
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }

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
                ThemeProvider.theme.collect {
                    binding.invalidateAll()
                }
            }
        }
    }

    private fun setupHandlers() {
        viewModel.loginLiveData.observe(viewLifecycleOwner, {
            if (it is UiState.Success<*>) {
                val value = (it as UiState.Success<String>).result
                Toast.makeText(requireContext(), value, Toast.LENGTH_LONG).show()
            }
        })
    }

}