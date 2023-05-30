package com.simbadev.galleryapp.model

import java.io.Serializable

data class Image(
    var image: String? = null,
    var isSelected: Boolean = false
) : Serializable