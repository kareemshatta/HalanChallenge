package com.example.halanchallenge.ui.product_list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.halanchallenge.databinding.ProductItemBinding
import com.kareem.domain.models.entities.products.Product

class ProductsListAdapter(private val listener: ItemClickListener) :
    RecyclerView.Adapter<ProductsListAdapter.ProductViewHolder>() {

    private var productsList = listOf<Product>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductsListAdapter.ProductViewHolder {
        return ProductViewHolder(
            ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductsListAdapter.ProductViewHolder, position: Int) {
        holder.bind(productsList[position])
    }

    override fun getItemCount(): Int = productsList.size

    inner class ProductViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.cardView.setOnClickListener {
                listener.onItemClick(productsList[adapterPosition])
            }
            binding.moreBtn.setOnClickListener {
                listener.onItemClick(productsList[adapterPosition])
            }
        }

        fun bind(product: Product) {
            Glide.with(binding.root.context).load(product.image).into(binding.productIv)
            binding.productItemTitleTv.text = product.name_ar
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setProductsList(newList: List<Product>){
        productsList = newList
        notifyDataSetChanged()
    }
}

interface ItemClickListener {
    fun onItemClick(product: Product)
}