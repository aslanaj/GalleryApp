package com.simbadev.galleryapp.ui.mainActvity


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simbadev.galleryapp.databinding.ItemGalleryBinding
import com.simbadev.galleryapp.loadImage
import com.simbadev.galleryapp.model.Image


class GalleryAdapter(
    private val imageList: ArrayList<Image>,
    private val addImage: (item: Image) -> Unit,
    private val removeImage: (item: Image) -> Unit,
    private val btnVisible: (item: Image) -> Unit

) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(
            ItemGalleryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    inner class GalleryViewHolder(private val binding: ItemGalleryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Image) {
            image.image?.let { binding.imageView.loadImage(it) }

            itemView.setOnClickListener {
                image.isSelected = !image.isSelected


                if (image.isSelected) {
                    binding.selectionOverlay.visibility = View.VISIBLE
                    addImage(image)
                    btnVisible(image)
                } else {
                    removeImage(image)
                    binding.selectionOverlay.visibility = View.GONE
                }

            }
        }
    }

}