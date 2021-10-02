package com.bobnevpavel.app.model

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import com.bobnevpavel.app.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import org.json.JSONObject
import java.io.IOException
import com.google.gson.GsonBuilder

class RegisterRetrofit {
    fun registerUser(phoneNumber: String, navController: NavController){
        CoroutineScope(Dispatchers.IO).launch{
            postData(phoneNumber, navController)
        }
    }

    fun postData(phoneNumber:String, navController: NavController){
        val JSON = "application/json; charset=utf-8".toMediaType()
        val client = OkHttpClient()
        val data = JSONObject()
        data.put("phone_number", phoneNumber)
        val body = RequestBody.create(JSON, data.toString())
        val request =
            Request.Builder().url("http://194.15.46.219:8080/api/user/").post(body)
                .build()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val body = response?.body?.string()
                    val gsonBuilder = GsonBuilder().create()
                    Log.d("body", gsonBuilder.fromJson(body, Code::class.java).toString())
                    val bundle = Bundle()
                    bundle.putString("CODE", gsonBuilder.fromJson(body, Code::class.java).toString())
                    CoroutineScope(Dispatchers.Main).launch {
                        navController.navigate(R.id.action_login_fragment_to_register_fragment, bundle)
                    }
                }
            }
            override fun onFailure(call: Call, e: IOException) {
                println("API execute failed")
            }
        })
    }
}