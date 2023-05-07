package com.example.apimultiplecall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apimultiplecall.Adapter.ResultAdapter
import com.example.apimultiplecall.viewmodel.ResultViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var characterList:RecyclerView
    lateinit var viewModel: ResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    viewModel =ViewModelProvider(this).get(ResultViewModel::class.java)
    characterList =findViewById(R.id.rVResult)
    characterList.layoutManager =LinearLayoutManager(this)
     observeCharactetrList()
    }

    private fun observeCharactetrList() {
        viewModel.resultLiveData.observe(this){
            characterList.adapter = it.results?.let { it1 -> ResultAdapter(it1,this@MainActivity) }
        }
    }
}