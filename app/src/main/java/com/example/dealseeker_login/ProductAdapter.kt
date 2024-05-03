package com.example.dealseeker_login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dealseeker_login.model.Product

class ProductAdapter : ListAdapter<Product, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        private val storeTextView: TextView = itemView.findViewById(R.id.storeTextView)
        private val wishlistCheckbox: CheckBox = itemView.findViewById(R.id.wishlistCheckbox)

        init {
            // Set a listener for the checkbox
            wishlistCheckbox.setOnCheckedChangeListener { _, isChecked ->
                val product = getItem(adapterPosition)
                product.isInWishlist = isChecked
                // Update the wishlist status in the database
                val dbHelper = ProductDatabaseHelper(itemView.context)
                dbHelper.updateWishlistStatus(product.id, isChecked)
            }
        }

        fun bind(product: Product) {
            nameTextView.text = product.name
            priceTextView.text = "$${product.price}"
            storeTextView.text = product.store
        }
    }

    private class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}
