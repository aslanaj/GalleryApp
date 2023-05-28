package com.simbadev.galleryapp

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.simbadev.galleryapp.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var allPictures: ArrayList<Image>? = null

    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.galleryRecyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.galleryRecyclerView.setHasFixedSize(true)

        initRegister()


        requestPermission()

        allPictures = ArrayList()
        if (allPictures!!.isEmpty()) {
            allPictures = getAllImages()
            binding.galleryRecyclerView?.adapter = GalleryAdapter(this, allPictures!!)
        }
    }

    private fun initRegister() {
        requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                allPictures = getAllImages()
                binding.galleryRecyclerView?.adapter = GalleryAdapter(this, allPictures!!)

                Log.e("ololo", "onCreate: ", )
            } else {
                Toast.makeText(this, "Разрешение не получено", Toast.LENGTH_SHORT).show()
            }
        }
    }



    private fun requestPermission() {
        if (ContextCompat.checkSelfPermission(
                this@MainActivity, Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            Log.e("ololo", "onCreate: ", )
        } else {
            allPictures = getAllImages()
            binding.galleryRecyclerView?.adapter = GalleryAdapter(this, allPictures!!)
        }
    }


    private fun getAllImages(): ArrayList<Image>? {
        val images = ArrayList<Image>()
        val allImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        val projection =
            arrayOf(MediaStore.Images.ImageColumns.DATA, MediaStore.Images.Media.DISPLAY_NAME)

        var cursor =
            this@MainActivity.contentResolver
                .query(
                    allImageUri, projection,
                    null,
                    null,
                    null
                )
        try {
            cursor!!.moveToFirst()
            do {
                val image = Image()
                image.imagePath =
                    cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA))
                image.imageName =
                    cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME))
                images.add(image)
            } while (cursor.moveToNext())
            cursor.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return images
    }

}