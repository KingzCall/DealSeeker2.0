package com.example.dealseeker_login

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dealseeker_login.databinding.ActivityMainBinding
import com.example.dealseeker_login.model.AppInitializer
import com.example.dealseeker_login.ui.theme.DealSeeker_LoginTheme

class MainActivity() : AppCompatActivity(), Parcelable {

    private lateinit var binding: ActivityMainBinding
    private lateinit var searchEditText: EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        setContent {
            DealSeeker_LoginTheme {
                val viewModel = viewModel<PermissionsViewModel>()
                val dialogQueue = viewModel.visiblePermissionDialogQueue

                val locationPermissionResultLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestPermission(),
                    onResult = { isGranted ->
                        viewModel.onPermissionResult(
                            permission = Manifest.permission.ACCESS_FINE_LOCATION,
                            isGranted = isGranted
                        )
                    }
                )

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {
                        locationPermissionResultLauncher.launch(
                            Manifest.permission.ACCESS_FINE_LOCATION
                        )
                    }) {
                        Text(text = "Request Location permission")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }

                dialogQueue
                    .reversed()
                    .forEach { permission ->
                        PermissionDialog(
                            permissionTextProvider = when (permission) {
                                Manifest.permission.ACCESS_FINE_LOCATION -> {
                                    LocationPermissionTextProvider()
                                }
                                else -> return@forEach
                            },
                            isPermanentlyDeclined = !shouldShowRequestPermissionRationale(
                                permission
                            ),
                            onDismiss = viewModel::dismissDialog,
                            onOkClick = {
                                viewModel.dismissDialog()
                            },
                            onGoToAppSettingsClick = {openAppSettings()}


                        )
                    }

            }

        }

        //populate database method
        AppInitializer.initDatabase(this)
        replaceFragment(Home())

        // searchEditText = findViewById(R.id.searchEditText)
        // recyclerView = findViewById(R.id.recyclerView)
        //
        // adapter = ProductAdapter()
        // recyclerView.layoutManager = LinearLayoutManager(this)
        // recyclerView.adapter = adapter
        //
        // searchEditText.addTextChangedListener(object : TextWatcher {
        // override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        //
        // override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        //
        // override fun afterTextChanged(s: Editable?) {
        // val searchTerm = s.toString().trim()
        // searchProducts(searchTerm)
        // }
        // })
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

    private fun Activity.openAppSettings(){
        Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", packageName, null)
        ).also(::startActivity)
    }

    private fun searchProducts(searchTerm: String) {
        val dbHelper = ProductDatabaseHelper(this)
        val productList = dbHelper.searchProductsByName(searchTerm)
        adapter.submitList(productList)
    }

    private fun replaceFragment(fragment:Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}


