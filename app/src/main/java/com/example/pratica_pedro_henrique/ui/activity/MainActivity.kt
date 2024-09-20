package com.example.pratica_pedro_henrique.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pratica_pedro_henrique.R
import com.example.pratica_pedro_henrique.databinding.ActivityMainBinding
import com.example.pratica_pedro_henrique.ui.fragment.FunnyFragment
import com.example.pratica_pedro_henrique.ui.fragment.SurpriseFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(FunnyFragment())

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.funny -> {
                    replaceFragment(FunnyFragment())
                    true
                }

                R.id.surprise -> {
                    replaceFragment(SurpriseFragment())
                    true
                }

                else -> false
            }

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.frameLayout.id, fragment)
            .commit()
    }
}