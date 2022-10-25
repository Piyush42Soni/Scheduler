package com.example.scheduler.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.scheduler.MonthlyAdapter
import com.example.scheduler.R
import com.example.scheduler.database.Points
import com.example.scheduler.databinding.FragmentMonthlyBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.coroutines.*
import javax.inject.Inject

@FragmentScoped
@AndroidEntryPoint
class MonthlyFragment : Fragment() {
    var adapterHai: MonthlyAdapter?=null
    private val viewModel: InputFragmentViewModel by viewModels()
    private lateinit var dataHai:List<Points>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        // Inflate the layout for this fragment
        val binding=DataBindingUtil.inflate<FragmentMonthlyBinding>(inflater,R.layout.fragment_monthly, container, false)
        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.Default) { dataHai=viewModel.getAll()}
            adapterHai= MonthlyAdapter(dataHai)
            binding.recyclerViewHai.adapter=adapterHai
        }
        return binding.root
    }

}