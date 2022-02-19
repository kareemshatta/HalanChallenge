package com.example.halanchallenge.ui.login

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.halanchallenge.R
import com.example.halanchallenge.databinding.FragmentLoginBinding
import com.kareem.domain.models.inputs.LoginInput
import com.kareem.domain.result.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private val viewModel by viewModels<AuthViewModel>()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private var job = Job()
    private val coroutineContext: CoroutineContext = Dispatchers.Main + job

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setupViewController()
    }

    @SuppressLint("CheckResult")
    private fun initView() {
        Glide.with(this).load(R.raw.online_shopping).into(binding.ivLoginPhoto)
        observeToUIState()
    }

    private fun observeToUIState() {
        lifecycleScope.launch(coroutineContext) {
            viewModel.uiState.collect { uiState ->
                when (uiState) {
                    is Resource.Success -> {
                        binding.pbLoadingBar.isVisible = false
                        //TODO navigate to products list view
                        Toast.makeText(
                            requireContext(),
                            "success",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    is Resource.Error -> {
                        binding.pbLoadingBar.isVisible = false
                        Toast.makeText(
                            requireContext(),
                            uiState.message ?: "An unexpected error occurred",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    is Resource.Loading -> {
                        binding.pbLoadingBar.isVisible = true
                    }
                    else -> {}
                }
            }
        }
    }

    private fun setupViewController() {
        binding.btnLogin.setOnClickListener {
            lifecycleScope.launch(coroutineContext) {
                viewModel.login(
                    LoginInput(
                        binding.etLoginUserName.text.trim().toString(),
                        binding.etLoginPassword.text.trim().toString()
                    )
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        job.cancel()
    }
}