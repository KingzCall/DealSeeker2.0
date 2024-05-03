package com.example.dealseeker_login

import android.os.Bundle
import com.example.dealseeker_login.Home
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.dealseeker_login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().
        replace(R.id.frame_layout, Home())
            .addToBackStack(null)
            .commit()


        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                androidx.appcompat.R.id.home -> {
                    supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, Home())
                        .commit()
                }
                R.id.search -> replaceFragment(Search())
                R.id.profile -> replaceFragment(Profile())
                R.id.wishlist -> replaceFragment(Wishlist())
                R.id.btnPhones -> {
                    // Handle button click on the Phones and GPS page
                    replaceFragment(PhonesAndGPS())
                }
                else -> {
                    // Handle other menu items if needed
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .addToBackStack(null)
            .commit()

        //val fragmentManager = supportFragmentManager
        //val fragmentTransaction = fragmentManager.beginTransaction()
        //fragmentTransaction.replace(R.id.frame_layout, fragment)
        //fragmentTransaction.addToBackStack(null) // Add fragment to back stack
        //fragmentTransaction.commit()
    }
}