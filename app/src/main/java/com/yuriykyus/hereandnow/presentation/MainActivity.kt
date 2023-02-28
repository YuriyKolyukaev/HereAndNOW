package com.yuriykyus.hereandnow.presentation

import androidx.appcompat.app.AppCompatActivity
import com.yuriykyus.hereandnow.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.liveData.observe(this, Observer { text ->
            binding.tvCity.text = text
        })

        viewModel = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        binding.tvCity.text = viewModel.getCity()
    }
}