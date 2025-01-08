package com.example.eco_alpha_test.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.eco_alpha_test.R
import com.example.eco_alpha_test.databinding.MainActivityBinding
import com.example.eco_alpha_test.presentation.first_screen.FirstScreenFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            initFragment()
        }
    }
    private fun initFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_fragment, FirstScreenFragment())
            .commit()
    }
}
