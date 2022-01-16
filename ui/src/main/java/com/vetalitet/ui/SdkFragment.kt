package com.vetalitet.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.vetalitet.foundation.FoundationConstants
import com.vetalitet.themes.ThemeProvider
import com.vetalitet.ui.databinding.FragmentSdkBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SdkFragment : Fragment() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main + Job())
    private val viewModel by lazy {
        ViewModelProvider(this)[SdkViewModel::class.java]
    }

    private lateinit var binding: FragmentSdkBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSdkBinding.inflate(inflater, container, false)
        binding.theme = ThemeProvider.currentTheme.value
        binding.shouldBeVisible = true
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTheme()
        setupHandlers()
    }

    private fun setupTheme() {
        //Handler().postDelayed({
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    ThemeProvider.theme.collect {
                        binding.invalidateAll()
                    }
                }
            }
        //}, 1000)
    }

    private fun setupHandlers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.testFlow.collect {
                    requireView().findViewById<TextView>(R.id.tv1).text = it
                }
            }
        }
        requireView().findViewById<Button>(R.id.btn).setOnClickListener {
            Toast.makeText(requireContext(), FoundationConstants.CONST1, Toast.LENGTH_LONG).show()
        }
    }

}
