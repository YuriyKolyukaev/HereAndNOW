package com.yuriykyus.walry.presentation

import androidx.appcompat.app.AppCompatActivity
import com.yuriykyus.walry.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.yuriykyus.walry.presentation.fragments.BaseFragment
import com.yuriykyus.walry.presentation.fragments.PagerFragment

class MainActivity : AppCompatActivity(), Navigator {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        addFragment(PagerFragment())

        onBackPressedDis()
    }

    override fun addFragment(fragment: BaseFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.container.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun hideLoad() {
        binding.progressBar.visibility = View.GONE
    }

    override fun showLoad() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun backFragment() {
        onBackPressedDispatcher.onBackPressed()
    }

    private fun onBackPressedDis() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (supportFragmentManager.backStackEntryCount == 1) finish()
                else supportFragmentManager.popBackStack()
            }
        })
    }
}