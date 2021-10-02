package com.bobnevpavel.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bobnevpavel.app.model.Database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class QuizAnimation : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @ExperimentalStdlibApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val database = context?.let { Database(it) }
        if (database != null) {
            database.getQuestions(this)
        }

        return inflater.inflate(R.layout.fragment_quiz_animation, container, false)
    }

    fun onQuizesIsGetted(list:List<HashMap<String, Object>>){
        val bundle = Bundle()
        var title_list = ArrayList<String>()
        var category_id = ArrayList<Int>()
        for (i in list.indices){
            title_list.add(list[i].get("title").toString())
            category_id.add(list[i].get("type_id").toString().toInt())
        }
        bundle.putIntegerArrayList("CATEGORY_ID", category_id)
        bundle.putStringArrayList("TITLE", title_list)
        CoroutineScope(Dispatchers.Main).launch {
            findNavController().navigate(R.id.action_quiz_animation_fragment_to_quiz_fragment, bundle)
        }
    }
}