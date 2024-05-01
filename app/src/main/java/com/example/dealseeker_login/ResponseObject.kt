package com.example.dealseeker_login

class responseObject(private var message: String) {

    //creating a getter method
    fun getMessage(): String {
        return message
    }

    //creating a setter method
    fun setMessage(message: String) {
        this.message = message
    }
}