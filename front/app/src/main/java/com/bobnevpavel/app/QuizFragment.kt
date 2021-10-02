package com.bobnevpavel.app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bobnevpavel.app.databinding.FragmentQuizBinding
import com.bobnevpavel.app.util.QuizAdapter

class QuizFragment() : Fragment() {
    lateinit var binding: FragmentQuizBinding
    private lateinit var questions: ArrayList<String>
    private lateinit var category_type: ArrayList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @ExperimentalStdlibApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        questions = arguments?.getStringArrayList("TITLE") as ArrayList<String>
        category_type = arguments?.getIntegerArrayList("CATEGORY_ID") as ArrayList<Int>
        Log.d("quest", questions.toString())
        binding.quizViewPager.adapter = context?.let {
            QuizAdapter(questions, category_type, binding.quizViewPager, this,
                it
            )
        }
        binding.quizViewPager.isUserInputEnabled = false
    }


}