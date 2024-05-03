package com.example.dealseeker_login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dealseeker_login.R
import com.example.dealseeker_login.model.Product
import com.example.dealseeker_login.model.ProductDatabaseHelper

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Home : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Find the button to add to wishlist
        val addToWishlistButton: Button = view.findViewById(R.id.addToWishlistButton)

        // Set click listener for add to wishlist button
        addToWishlistButton.setOnClickListener {
            // Get the product details from the current view or any other source
            val productId = 1 // Example product ID
            val productName = "Example Product" // Example product name
            val price = 10.0 // Example price
            val store = "Example Store" // Example store

            // Add the product to the wishlist using ProductDatabaseHelper
            val dbHelper = ProductDatabaseHelper(requireContext())
            dbHelper.addProduct(Product(productId, productName, price, store))

            // Show a message indicating the product was added to the wishlist
            Toast.makeText(requireContext(), "Item added to wishlist", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
