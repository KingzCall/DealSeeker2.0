package com.example.dealseeker_login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.dealseeker_login.databinding.ActivityMainBinding
import com.example.dealseeker_login.model.AppInitializer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        //populate database method
        AppInitializer.initDatabase(this)
        replaceFragment(Home())




        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                androidx.constraintlayout.widget.R.id.home -> replaceFragment(Home())
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


    private fun replaceFragment(fragment:Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}
