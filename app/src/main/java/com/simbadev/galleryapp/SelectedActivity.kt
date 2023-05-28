package com.simbadev.galleryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.simbadev.galleryapp.databinding.ActivitySelectedBinding

class SelectedActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imagePath = intent.getStringExtra("path")
        val imageName = intent.getStringExtra("name")

         supportActionBar?.setTitle(imageName)

        Glide.with(this).load(imagePath)
            .into(binding.imageView)


    }
}