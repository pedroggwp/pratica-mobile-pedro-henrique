package com.example.pratica_pedro_henrique

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pratica_pedro_henrique.databinding.ActivityMainBinding
import com.example.pratica_pedro_henrique.fragments.HomeFragment
import com.example.pratica_pedro_henrique.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.settings -> {
                    replaceFragment(SettingsFragment())
                    true
                }

                else -> false
            }

        }
    }

    private fun replaceFragment(fragment: Fragment) : Unit {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.frameLayout.id, fragment)
            .commit()
    }
}