package com.bobnevpavel.app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.Alignment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bobnevpavel.app.databinding.FragmentCourcesBinding
import com.bobnevpavel.app.databinding.FragmentSignUpBinding
import com.bobnevpavel.app.model.Database
import com.bobnevpavel.app.util.CoursesAdapter


class CourcesFragment : Fragment() {
    lateinit var binding: FragmentCourcesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCourcesBinding.inflate(inflater, container, false)
        startDownload()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    fun startDownload(){
        Database(context = context).getCourses(this)
    }

    fun startRecyclerView(list:List<HashMap<String, Object>>){
        binding.recyclerView.adapter = CoursesAdapter(list, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        (binding.recyclerView.adapter as CoursesAdapter).notifyDataSetChanged()
    }
    fun startCourseFragment(map:HashMap<String, Object>){
        Log.d("Map", map.toString())
        val bundle = Bundle()
        val phone = map.get("contact").toString()
        val title = map.get("title").toString()
        val address = map.get("address").toString()
        val description = map["description"].toString()
        val type = map.get("type_id").toString().toInt()
        bundle.putString("CONTACT", phone)
        bundle.putString("TITLE", title)
        bundle.putString("ADDRESS", address)
        bundle.putString("DESCRIPTION", description)
        bundle.putInt("TYPE", type)
        findNavController().navigate(R.id.action_courses_fragment_to_course_fragment, bundle)
    }
}