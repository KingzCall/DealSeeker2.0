package com.example.dealseeker_login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.dealseeker_login.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

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

        // Retrofit implementation
        val retrofit = Retrofit.Builder()
            .baseUrl("https://json.extendsclass.com/bin/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitAPI = retrofit.create(RetrofitAPICall::class.java)

        val call: Call<ResponseObject> = retrofitAPI.getData()

        call.enqueue(object : Callback<ResponseObject> {
            override fun onResponse(call: Call<ResponseObject>, response: Response<ResponseObject>) {
                // Handle response
                val responseObject = response.body()
                // You can handle the response object here
            }

            override fun onFailure(call: Call<ResponseObject>, t: Throwable) {
                // Handle failure
            }
        })
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}
