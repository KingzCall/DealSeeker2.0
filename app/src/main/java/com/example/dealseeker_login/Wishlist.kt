package com.example.dealseeker_login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class Wishlist : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_wishlist, container, false)

        // Find the button to add to wishlist
        val addToWishlistButton: Button = view.findViewById(R.id.addToWishlistButton)

        // Set click listener for add to wishlist button
        addToWishlistButton.setOnClickListener {
            // Simulate adding to wishlist (replace with your actual logic)
            addToWishlist()

            // Show toast message to indicate item added to wishlist
            Toast.makeText(requireContext(), "Item added to wishlist", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    private fun addToWishlist() {
        // Simulate adding to wishlist (replace with your actual logic)
        val product = getProductToAddToWishlist()
        if (product != null) {
            addToWishlist(product.id, product.name, product.price, product.store)
        }
    }

    private fun getProductToAddToWishlist(): Product? {
        // Replace this with logic to get the product the user wants to add to the wishlist
        // For demonstration purposes, let's create a dummy product
        return Product(1, "Dummy Product", 10.0, "Dummy Store")
    }

    // Function to simulate adding to wishlist (replace with your actual logic)
    private fun addToWishlist(productId: Int, productName: String, price: Double, store: String) {
        val dbHelper = ProductDatabaseHelper(requireContext())

        // Create a new Product object with the provided details
        val product = Product(productId, productName, price, store)

        // Add the product to the wishlist by inserting it into the database
        dbHelper.addProduct(product)
    }

}

