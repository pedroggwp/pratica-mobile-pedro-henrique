package com.example.pratica_pedro_henrique.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.pratica_pedro_henrique.databinding.FragmentSurpriseBinding
import com.example.pratica_pedro_henrique.webclient.service.PhotoService
import com.example.pratica_pedro_henrique.webclient.service.TextService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SurpriseFragment : Fragment() {

    private lateinit var binding: FragmentSurpriseBinding
    private lateinit var photoRetrofit: Retrofit
    private lateinit var textRetrofit: Retrofit
    private lateinit var photoService: PhotoService
    private lateinit var textService: TextService

    companion object {
        private const val ARG_API_TYPE = "api_type"
        const val API_TYPE_PHOTO = "photo"
        const val API_TYPE_TEXT = "text"

        fun newInstance(apiType: String): SurpriseFragment {
            val fragment = SurpriseFragment()
            val args = Bundle().apply {
                putString(ARG_API_TYPE, apiType)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSurpriseBinding.inflate(inflater, container, false)

        photoRetrofit = Retrofit.Builder()
            .baseUrl("https://api.imgflip.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        photoService = photoRetrofit.create(PhotoService::class.java)

        textRetrofit = Retrofit.Builder()
            .baseUrl("https://api.gameofthronesquotes.xyz")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        textService = textRetrofit.create(TextService::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiType = arguments?.getString(ARG_API_TYPE)

        viewLifecycleOwner.lifecycleScope.launch {
            when (apiType) {
                API_TYPE_PHOTO -> callPhotoApi()
                API_TYPE_TEXT -> callTextApi()
                else -> {
                    callPhotoApi()
                    callTextApi()
                }
            }
        }
    }

    private suspend fun callPhotoApi() {
        val response = photoService.getPhoto()

        if (response.isSuccessful) {
            response.body()?.data?.memes?.let { memes ->
                if (memes.isNotEmpty()) {
                    val randomMeme = memes.random()
                    val imageUrl = randomMeme.url

                    Glide.with(requireContext())
                        .load(imageUrl)
                        .into(binding.imageSurprise)
                }
            }
        }
    }

    private suspend fun callTextApi() {
        val response = textService.getSentence()

        if (response.isSuccessful) {
            response.body()?.let { apiResponse ->
                val sentence = apiResponse.sentence

                Log.d("SENTEÇA", sentence)

                 binding.textSurprise.text = sentence
            }
        }
    }

}