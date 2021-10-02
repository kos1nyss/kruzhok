package com.bobnevpavel.app.model

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.findNavController
import com.bobnevpavel.app.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Database(context: Context?) {
    val database = Firebase.database("https://kruzhok-a794c-default-rtdb.europe-west1.firebasedatabase.app/")
    fun getCourses(fragment: CourcesFragment){
        database.reference.child("course").get().addOnSuccessListener {
            var list = it.getValue() as List<HashMap<String, Object>>
            fragment.startRecyclerView(list)
        }
    }

    fun getQuestions(fragment:QuizAnimation){
        database.reference.child("questions").child("name").get().addOnSuccessListener {
            var list = it.getValue() as List<HashMap<String, Object>>
            Log.d("QuestionsList", list.toString())
            fragment.onQuizesIsGetted(list)
        }.addOnFailureListener {
            Log.d("QuestionsList", "Failed")
        }
    }
}