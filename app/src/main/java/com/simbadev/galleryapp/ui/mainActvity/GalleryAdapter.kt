package com.simbadev.galleryapp.ui.mainActvity

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.simbadev.galleryapp.R
import com.simbadev.galleryapp.madel.Image
import com.simbadev.galleryapp.ui.selectedActivity.SelectedActivity


class GalleryAdapter(
    private var context: Context,
    private var imageList: ArrayList<Image>
) :
    RecyclerView.Adapter<GalleryAdapter.ImageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_gallery, parent, false)
        return ImageViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currentImage = imageList[position]

        Glide.with(context).load(currentImage.imagePath)
            .apply(RequestOptions().centerCrop())
            .into(holder.image!!)

        holder.image?.setOnClickListener {
            val intent = Intent(context, SelectedActivity::class.java)
            intent.putExtra("path", currentImage.imagePath)
            intent.putExtra("name", currentImage.imageName)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = imageList.size

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView? = null

        init {
            image = itemView.findViewById(R.id.imageView)
        }
    }
}