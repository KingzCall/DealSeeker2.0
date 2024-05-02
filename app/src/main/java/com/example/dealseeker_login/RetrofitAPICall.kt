package com.example.dealseeker_login

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPICall {
    @get:GET("43d590f03930")
    fun getData(): Call<ResponseObject>
}
