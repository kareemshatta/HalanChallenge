package com.example.halanchallenge.ui.product_details

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.navigateUp
import com.example.halanchallenge.R
import com.example.halanchallenge.databinding.FragmentProductDetailsBinding
import com.example.halanchallenge.ui.product_details.adapter.ProductsImagesAdapter

class ProductDetailsFragment : Fragment(){
    private var _binding: FragmentProductDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: ProductDetailsFragmentArgs by navArgs()
    private val productImagesAdapter by lazy {
        ProductsImagesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setupProductImagesRecyclerView()
        setupViewController()
    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        with(args.product) {
            binding.productDescriptionTv.text = deal_description
            binding.productDetailsTitleTv.text = name_ar
            binding.productDescriptionTv.movementMethod = ScrollingMovementMethod()
            binding.productPriceTv.text = "كاش" + "           " + price + "جنيه"
        }
    }

    private fun setupProductImagesRecyclerView() {
        with(binding){
            productImagesAdapter.setProductsList(args.product.images)
            productImagesBanner.adapter = productImagesAdapter
            arIndicator.attachTo(productImagesBanner, true)
        }
    }

    private fun setupViewController() {
        binding.materialButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}