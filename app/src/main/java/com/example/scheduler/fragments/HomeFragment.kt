package com.example.scheduler.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.scheduler.R
import com.example.scheduler.databinding.FragmentHomeBinding
import dagger.hilt.android.scopes.FragmentScoped
import java.util.zip.Inflater
@FragmentScoped
class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home, container, false)
        binding.ThemeButton.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_homeFragment_to_inputFragment)
        }
        return binding.root
    }
}