package com.example.halanchallenge.ui.product_details.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.halanchallenge.databinding.ImageViewItemBinding

class ProductsImagesAdapter : RecyclerView.Adapter<ProductsImagesAdapter.ProductImagesViewHolder>() {

    private var imagesList = listOf<String>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductsImagesAdapter.ProductImagesViewHolder {
        return ProductImagesViewHolder(
            ImageViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: ProductsImagesAdapter.ProductImagesViewHolder,
        position: Int
    ) {
        holder.bind(imagesList[position])
    }

    override fun getItemCount(): Int = imagesList.size

    inner class ProductImagesViewHolder(private val binding: ImageViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(imageUrl: String) {
            Glide.with(binding.root.context).load(imageUrl).into(binding.productImageIV)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setProductsList(newImagesList: List<String>) {
        imagesList = newImagesList
        notifyDataSetChanged()
    }
}