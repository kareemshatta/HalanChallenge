package com.example.halanchallenge.ui.product_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.halanchallenge.databinding.FragmentProductsListBinding
import com.example.halanchallenge.ui.product_list.adapter.ItemClickListener
import com.example.halanchallenge.ui.product_list.adapter.ProductsListAdapter
import com.kareem.domain.models.entities.LoginResponse
import com.kareem.domain.models.entities.products.Product
import com.kareem.domain.result.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class ProductsListFragment : Fragment(), ItemClickListener {
    private val viewModel by viewModels<ProductsListViewModel>()
    private var _binding: FragmentProductsListBinding? = null
    private val binding get() = _binding!!
    private var job = Job()
    private val coroutineContext: CoroutineContext = Dispatchers.Main + job
    private val args: ProductsListFragmentArgs by navArgs()
    private val productsListAdapter by lazy {
        ProductsListAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setupProductsRecyclerView()
        observeOnUIState()
        setupViewController()
    }

    private fun initView() {
        with(args.loginResponse.profile) {
            Glide.with(requireActivity()).load(image).into(binding.userIv)
            binding.usernameTv.text = name
            binding.emailTv.text = email
            binding.phoneNumberTv.text = phone
        }
    }

    private fun setupProductsRecyclerView() {
        binding.productsListRv.adapter = productsListAdapter
        viewModel.getProductsList(args.loginResponse.token)
    }

    private fun observeOnUIState() {
        lifecycleScope.launch(coroutineContext) {
            viewModel.uiState.collect { uiState ->
                when (uiState) {
                    is Resource.Success -> {
                        binding.productsProgressBar.isVisible = false
                        productsListAdapter.setProductsList(uiState.data?.products ?: listOf())
                    }
                    is Resource.Error -> {
                        binding.productsProgressBar.isVisible = false
                        Toast.makeText(
                            requireContext(),
                            uiState.message ?: "An unexpected error occurred",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    is Resource.Loading -> {
                        binding.productsProgressBar.isVisible = true
                    }
                    else -> {}
                }
            }
        }
    }

    private fun setupViewController() {
        binding.logoutIV.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onItemClick(product: Product) {
//        val myBundle = Bundle()
//        myBundle.putParcelable("ITEM", item)
//        val myIntent = Intent(
//            context,
//            ProductDetailsActivity::class.java
//        ).putExtra("PARCELABLE", myBundle)
//        myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//        context.startActivity(myIntent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        job.cancel()
    }
}