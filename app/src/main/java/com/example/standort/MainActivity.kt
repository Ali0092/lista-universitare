package com.example.standort

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standort.Constants.CountyName
import com.example.standort.adapter.ItemAdapter
import com.example.standort.databinding.ActivityMainBinding
import com.example.standort.viewModel.appViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myAdapter by lazy {  ItemAdapter() }
    private val vm by viewModels<appViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SettingUpRecyclerView()
        binding.search.setOnClickListener {
          val name=binding.textView.text?.toString()
          if(!name.isNullOrEmpty())
              vm.getResponses(name)
        }
        vm.responseList.observe(this, Observer { response->
          if(response.isSuccessful){
              let {
                  response.body()?.let { myAdapter.setListofData(it) }
              }
          }
            else Toast.makeText(baseContext,"Unsuccessful",Toast.LENGTH_SHORT).show()
        })


    }

    private fun SettingUpRecyclerView(){
        binding.recView.adapter=myAdapter
        binding.recView.layoutManager=LinearLayoutManager(this)
    }
}