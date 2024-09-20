package com.example.pratica_pedro_henrique.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.pratica_pedro_henrique.R
import com.example.pratica_pedro_henrique.databinding.FragmentFunnyBinding
import com.example.pratica_pedro_henrique.webclient.service.PhotoService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FunnyFragment : Fragment() {

    private lateinit var binding: FragmentFunnyBinding
    private lateinit var retrofit: Retrofit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFunnyBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageTobeOrNot.setOnClickListener {
            val surpriseFragment = SurpriseFragment.newInstance(SurpriseFragment.API_TYPE_PHOTO)

            parentFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, surpriseFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.imageFunFact.setOnClickListener {
            val surpriseFragment = SurpriseFragment.newInstance(SurpriseFragment.API_TYPE_TEXT)

            parentFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, surpriseFragment)
                .addToBackStack(null)
                .commit()
        }
    }

}