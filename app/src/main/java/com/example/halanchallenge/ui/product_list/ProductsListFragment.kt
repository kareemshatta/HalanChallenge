package com.example.halanchallenge.ui.product_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.halanchallenge.databinding.FragmentLoginBinding
import com.example.halanchallenge.databinding.FragmentProductsListBinding
import com.example.halanchallenge.utils.Constants.Companion.LOGIN_RESPONSE
import com.kareem.domain.models.entities.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class ProductsListFragment : Fragment() {
    private val viewModel by viewModels<ProductsViewModel>()
    private var _binding: FragmentProductsListBinding? = null
    private val binding get() = _binding!!
    private var job = Job()
    private val coroutineContext: CoroutineContext = Dispatchers.Main + job
    private lateinit var loginResponse: LoginResponse

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgs()
        initView()
        setupViewController()
    }

    private fun getArgs() {
        loginResponse = ProductsListFragmentArgs.fromBundle(requireArguments()).loginResponse
    }

    private fun initView() {
        with(loginResponse.profile) {
            Glide.with(requireActivity()).load(image).into(binding.userIv)
            binding.usernameTv.text = name
            binding.emailTv.text = email
            binding.phoneNumberTv.text = phone
        }
    }

    private fun setupViewController() {
        binding.logoutIV.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

    }
}