package com.bobnevpavel.app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bobnevpavel.app.model.Database


class LoadCoursesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        loadCourses()
        return inflater.inflate(R.layout.fragment_load_courses, container, false)

    }
    fun loadCourses(){
        if (this.context != null){
            Log.d("COURSES", "TRUE")
        }
    }
}