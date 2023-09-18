package com.admc.pruebatecnica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.admc.pruebatecnica.R
import com.admc.pruebatecnica.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private  val apodViewModel:ApodViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showApodP()


    }
    private fun showApodP(){
        apodViewModel.getRandomApod("XBPj5dNcEayI5BeJ3todCQ3ZHuRTJi8kEJa3svLd")
        apodViewModel.apodData.observe(this, Observer {currentApod->
           Picasso.get().load(currentApod.image).into(binding.ivImageDay)
            binding.tvTitle.text = currentApod.title
        })
    }

}