package com.simbadev.galleryapp.ui.selectedActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.simbadev.galleryapp.databinding.ItemGalleryBinding
import com.simbadev.galleryapp.loadImage
import com.simbadev.galleryapp.model.Image

class SelectedAdapter(
    val imageList: ArrayList<Image>
): Adapter<SelectedAdapter.SelectedViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedViewHolder {
        return SelectedViewHolder(
            ItemGalleryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: SelectedViewHolder, position: Int) {
        holder.bind()
    }



    inner  class SelectedViewHolder(private val binding: ItemGalleryBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = imageList[adapterPosition]
            item.image?.let { binding.imageView.loadImage(it) }
        }
    }

}




