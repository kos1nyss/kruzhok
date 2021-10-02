package com.bobnevpavel.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bobnevpavel.app.databinding.FragmentCourcesBinding
import com.bobnevpavel.app.databinding.FragmentCourseBinding
import android.content.Intent
import android.icu.number.NumberFormatter.with
import android.net.Uri
import android.util.Log
import androidx.core.view.PointerIconCompat.load
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.System.load
import java.util.ServiceLoader.load


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CourseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CourseFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentCourseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCourseBinding.inflate(inflater, container, false)
        binding.arrowBack.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_course_fragment_to_courses_fragment)
        })
        binding.fab.setOnClickListener(View.OnClickListener {
            val intent = Intent(
                Intent.ACTION_DIAL,
                Uri.fromParts("tel", binding.phone.text.toString(), null)
            )
            startActivity(intent)
        })
        binding.address.text = savedInstanceState?.getString("ADDRESS").toString()
        Log.d("test", arguments?.getString("ADDRESS").toString() )
        Log.d("test", arguments?.getString("ADDRESS").toString())
        binding.name.text = arguments?.getString("TITLE").toString()
        binding.description.text = arguments?.getString("DESCRIPTION").toString()
        binding.phone.text = "Телефон: " + arguments?.getString("CONTACT").toString()
        binding.address.text = "Адресс: " + arguments?.getString("ADDRESS").toString()
        when(arguments?.getInt("TYPE")){
            2 -> Picasso.get().load(R.drawable.free_icon_music_notes).into(binding.image)
            3 -> Picasso.get().load(R.drawable.free_icon_drama).into(binding.image)
            4 -> Picasso.get().load(R.drawable.free_icon_paint_tools).into(binding.image)
            5 -> Picasso.get().load(R.drawable.free_icon_judo).into(binding.image)
            6 -> Picasso.get().load(R.drawable.free_icon_jogging).into(binding.image)
            7 -> Picasso.get().load(R.drawable.free_icon_board_games).into(binding.image)
            8 -> Picasso.get().load(R.drawable.free_icon_physics).into(binding.image)
            8 -> Picasso.get().load(R.drawable.book_outline).into(binding.image)
        }
        return binding.root
    }
}
