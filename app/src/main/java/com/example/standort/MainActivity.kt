package com.example.standort

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.standort.databinding.ActivityMainBinding
import com.example.standort.viewModel.appViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vm=ViewModelProvider(this)[appViewModel::class.java]
        vm.str.observe(this, Observer {
            binding.checkTv.setText(it.toString())
        })

    }
}