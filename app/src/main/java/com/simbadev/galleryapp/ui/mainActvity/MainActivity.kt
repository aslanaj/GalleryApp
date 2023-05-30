package com.simbadev.galleryapp.ui.mainActvity


import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.simbadev.galleryapp.databinding.ActivityMainBinding
import com.simbadev.galleryapp.model.Image
import com.simbadev.galleryapp.ui.selectedActivity.SelectedActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: GalleryAdapter
    private val imageLists = arrayListOf<Image>()
    private val selectedPictures = mutableListOf<Image>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadImages()
        adapter = GalleryAdapter(imageLists, this::addImage, this::removeImage, this::btnVisible)
        binding.apply {
            rvGallery.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rvGallery.adapter = adapter
        }
        initClickListener()

    }

    private fun btnVisible(image: Image) {
        if (!image.isSelected) {
            binding.btnSelected.visibility = View.GONE
        } else {
            binding.btnSelected.visibility = View.VISIBLE
        }
    }

    private fun initClickListener() {
        binding.btnShowSelected.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable(KEY, ArrayList(selectedPictures))
            }
            val intent = Intent(applicationContext, SelectedActivity::class.java)
            intent.putExtras(bundle)
            imageLists.clear()
            selectedPictures.clear()
            startActivity(intent)
        }
    }


    private fun removeImage(image: Image) {
        selectedPictures.add(image)
    }

    private fun addImage(image: Image) {
        selectedPictures.add(image)
    }

    private fun loadImages() {
        imageLists.add(
            Image(
                "https://animecorner.me/wp-content/uploads/2022/10/naruto.png",
                false
            )
        )
        imageLists.add(
            Image(
                "https://overclockers.ru/st/legacy/blog/422417/370374_O.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://i.ytimg.com/vi/UGj4GMAGPAc/maxresdefault.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://www.hindustantimes.com/ht-img/img/2023/04/22/550x309/HIDIVE_OSHI_NO_KO_1682155135941_1682155148326.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://m.media-amazon.com/images/I/31iH1SJizUL._AC_UF1000,1000_QL80_.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://static.kinoafisha.info/upload/news/443819087407.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://img.asmedia.epimg.net/resizer/gy-ADnQWtaBop3GYhMfX7qW5Xbk=/644x362/cloudfront-eu-central-1.images.arcpublishing.com/diarioas/O3FUPP4PEZI7PFP6WCUQX5HFTM.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://www.hindustantimes.com/ht-img/img/2023/04/22/550x309/HIDIVE_OSHI_NO_KO_1682155135941_1682155148326.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://m.media-amazon.com/images/I/31iH1SJizUL._AC_UF1000,1000_QL80_.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://www.shutterstock.com/image-photo/japanese-girl-anime-warriorjapanese-deaushka-260nw-2026469507.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://i.ytimg.com/vi/UGj4GMAGPAc/maxresdefault.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://static.kinoafisha.info/upload/news/443819087407.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://www.hindustantimes.com/ht-img/img/2023/04/22/550x309/HIDIVE_OSHI_NO_KO_1682155135941_1682155148326.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://m.media-amazon.com/images/I/31iH1SJizUL._AC_UF1000,1000_QL80_.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://www.hindustantimes.com/ht-img/img/2023/04/22/550x309/HIDIVE_OSHI_NO_KO_1682155135941_1682155148326.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://m.media-amazon.com/images/I/31iH1SJizUL._AC_UF1000,1000_QL80_.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://www.shutterstock.com/image-photo/japanese-girl-anime-warriorjapanese-deaushka-260nw-2026469507.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://i.ytimg.com/vi/UGj4GMAGPAc/maxresdefault.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://static.kinoafisha.info/upload/news/443819087407.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://www.hindustantimes.com/ht-img/img/2023/04/22/550x309/HIDIVE_OSHI_NO_KO_1682155135941_1682155148326.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://m.media-amazon.com/images/I/31iH1SJizUL._AC_UF1000,1000_QL80_.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://www.hindustantimes.com/ht-img/img/2023/04/22/550x309/HIDIVE_OSHI_NO_KO_1682155135941_1682155148326.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://m.media-amazon.com/images/I/31iH1SJizUL._AC_UF1000,1000_QL80_.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://www.shutterstock.com/image-photo/japanese-girl-anime-warriorjapanese-deaushka-260nw-2026469507.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://i.ytimg.com/vi/UGj4GMAGPAc/maxresdefault.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://static.kinoafisha.info/upload/news/443819087407.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://www.hindustantimes.com/ht-img/img/2023/04/22/550x309/HIDIVE_OSHI_NO_KO_1682155135941_1682155148326.jpg",
                false
            )
        )
        imageLists.add(
            Image(
                "https://m.media-amazon.com/images/I/31iH1SJizUL._AC_UF1000,1000_QL80_.jpg",
                false
            )
        )


    }


    companion object {
        const val KEY = "key"
    }
}