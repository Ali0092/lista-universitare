package com.example.standort

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.standort.databinding.ActivityMainBinding
import com.example.standort.viewModel.appViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var vm:appViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       vm=ViewModelProvider(this)[appViewModel::class.java]

        vm.fact.observe(this, androidx.lifecycle.Observer {
            Glide.with(applicationContext)
                .load("${it.message}")
                .into(binding.checkIv)
        })


    }


}