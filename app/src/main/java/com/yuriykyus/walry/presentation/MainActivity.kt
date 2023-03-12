package com.yuriykyus.walry.presentation

import androidx.appcompat.app.AppCompatActivity
import com.yuriykyus.walry.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.View
import com.yuriykyus.walry.presentation.fragments.PagerFragment

class MainActivity : AppCompatActivity(), Navigator {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setPagerFragment()
    }

    private fun setPagerFragment() {
        val fragmentManager = supportFragmentManager

        val transaction = fragmentManager.beginTransaction()
        transaction.replace(binding.container.id, PagerFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun hideLoad() {
        binding.progressBar.visibility = View.GONE
    }

    override fun showLoad() {
        binding.progressBar.visibility = View.VISIBLE
    }

}