package com.bobnevpavel.app

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bobnevpavel.app.databinding.FragmentLoginBinding
import com.bobnevpavel.app.model.RegisterRetrofit
import com.google.android.material.snackbar.Snackbar


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding =  FragmentLoginBinding.inflate(inflater, container, false)
        binding.loginButton.setOnClickListener(View.OnClickListener {
            checkUserNumber(binding.emailEditText.text, binding.root)
        })
        return binding.root
    }

    fun checkUserNumber(number: Editable, view: View){
        if (number.toString().length == 0 || number.toString().length > 12){
            Snackbar.make(view, "Invalid number exception", Snackbar.LENGTH_LONG).show()
        }
        else{
            RegisterRetrofit().registerUser(number.toString(), findNavController())
        }
    }
}