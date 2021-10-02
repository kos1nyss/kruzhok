package com.bobnevpavel.app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bobnevpavel.app.databinding.FragmentSignUpBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpGragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpGragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var code: String? = null
    private lateinit var binding: FragmentSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            code = savedInstanceState.get("CODE").toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        code = arguments?.getString("CODE")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentSignUpBinding.inflate(inflater, container, false)
        binding.loginButton.setOnClickListener(View.OnClickListener {
            if (binding.emailEditText.text.toString() != code){
                Log.d("body", code.toString())
                invalidCodeException(binding.root)
            }else{
                findNavController().navigate(R.id.action_register_fragment_to_quiz_fragment)
            }
        })
        return binding.root
    }

    fun invalidCodeException(view: View){
        Snackbar.make(view, "Invalid code", Snackbar.LENGTH_LONG).show()
    }
}