/*
 * Copyright (c) 2022.
 * All Rights Reserved
 */

package com.example.scheduler.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.scheduler.R
import com.example.scheduler.databinding.FragmentLoginBinding
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class LoginFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding=DataBindingUtil.inflate<FragmentLoginBinding>(inflater,R.layout.fragment_login, container, false)
        binding.buttonFirst.setOnClickListener {
            if(binding.passwordhai.text.toString()=="YOHO"){
                NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_homeFragment)
            }
            else{
                Toast.makeText(this.context,"Wrong Password",Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }
}