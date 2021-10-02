package com.bobnevpavel.app.util

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bobnevpavel.app.*

class QuizAdapter(
    val listQuestions: List<String>,
    val listType: List<Int>, val pager:ViewPager2, val fragment:QuizFragment, val context: Context
) : RecyclerView.Adapter<PagerVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.fragment_quiz_question, parent, false), QuizQuestionFragment())

    override fun getItemCount(): Int = listQuestions.size

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        holder.firstButton.setOnClickListener(View.OnClickListener {
            if (pager.currentItem != listQuestions.size) {
                pager.currentItem = pager.currentItem + 1
            }
            if (pager.currentItem == listQuestions.size - 1){
                fragment.findNavController().navigate(R.id.action_quiz_fragment_to_courses_fragment)
            }
        })
        holder.secondButton.setOnClickListener(View.OnClickListener {
            if (pager.currentItem != listQuestions.size) {
                pager.currentItem = pager.currentItem + 1
                Log.d("Pager", "True")
            }
            if (pager.currentItem == listQuestions.size - 1){
                fragment.findNavController().navigate(R.id.action_quiz_fragment_to_courses_fragment)
            }
        })
        holder.questionCount.text = (position + 1).toString()
        holder.counter.setText((position + 1).toString() + " / " + (listQuestions.size - 1).toString() )
        holder.queston.setText(listQuestions[position])
    }
}

class PagerVH(itemView: View, fragment: QuizQuestionFragment) : RecyclerView.ViewHolder(itemView){
    val questionCount = itemView.findViewById<TextView>(R.id.count)
    val queston = itemView.findViewById<TextView>(R.id.question)
    val counter = itemView.findViewById<TextView>(R.id.counter)
    val firstButton = itemView.findViewById<Button>(R.id.first_answer_button)
    val secondButton = itemView.findViewById<Button>(R.id.second_answer_button)
}