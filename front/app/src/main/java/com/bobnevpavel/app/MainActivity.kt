package com.bobnevpavel.app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class MainActivity : AppCompatActivity() {
    var list:List<HashMap<String, Object>> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    @SuppressLint("ResourceType")
    fun loadCourses(list:List<HashMap<String, Object>>){

    }
}