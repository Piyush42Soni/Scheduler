/*
 * Copyright (c) 2022.
 * All Rights Reserved
 */

package com.example.scheduler.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.text.isDigitsOnly
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.scheduler.R
import com.example.scheduler.database.Points
import com.example.scheduler.databinding.FragmentInputBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.coroutines.*
import java.time.OffsetDateTime

@FragmentScoped
@AndroidEntryPoint
class InputFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private val viewModel: InputFragmentViewModel by viewModels()
    @OptIn(DelicateCoroutinesApi::class)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=DataBindingUtil.inflate<FragmentInputBinding>(inflater,R.layout.fragment_input, container, false)
        var b=true
        binding.submitButton.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                if ((binding.BookText.text.toString().isDigitsOnly())
                    and (binding.codeText.text.toString().isDigitsOnly())
                    and (binding.studyText.text.toString().isDigitsOnly())
                    and (binding.exerciseText.text.toString().isDigitsOnly())
                    and (binding.screenTime.text.toString().isDigitsOnly())
                    and (binding.wakeText.text.toString().isDigitsOnly())
                ) {
                    val point = Points(
                        Book = (binding.BookText.text.toString().toInt()),
                        Date = OffsetDateTime.now(),
                        Calories_burnt = binding.exerciseText.text.toString().toFloat(),
                        ScreenTime = binding.screenTime.text.toString().toFloat(),
                        Coding_Questions = binding.codeText.text.toString().toInt(),
                        CollegeStudy = binding.studyText.text.toString().toFloat(),
                        Wake = binding.wakeText.text.toString().toInt(),
                        NP = binding.NPicon.isChecked
                    )
                    withContext(Dispatchers.Default) {
                        val points=viewModel.getone()

                        b = if(points==null){
                            viewModel.Insert(point)
                            true
                        }
                        else if(points.Date?.dayOfMonth!=point.Date?.dayOfMonth) {
                            viewModel.Insert(point)
                            true
                        } else {
                            false
                        }
                    }
                    if(b) {
                        Toast.makeText(context, "Data saved", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(context, "Today's Data already saved", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Fill all data", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.clearButton.setOnClickListener {
            binding.BookText.setText("")
            binding.codeText.setText("")
            binding.studyText.setText("")
            binding.exerciseText.setText("")
            binding.screenTime.setText("")
            binding.wakeText.setText("")

        }
        return binding.root
    }
}