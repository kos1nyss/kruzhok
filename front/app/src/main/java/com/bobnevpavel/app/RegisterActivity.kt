package com.bobnevpavel.app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

class RegisterActivity : AppCompatActivity() {
    var list:List<HashMap<String, Object>> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    @SuppressLint("ResourceType")
    fun getDownloads(list : List<HashMap<String, Object>>){
        this.list = list

    }
}