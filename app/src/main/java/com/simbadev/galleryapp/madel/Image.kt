package com.simbadev.galleryapp.madel

class Image {
    var imagePath: String? = null
    var imageName: String? = null

    constructor(imagePath: String?, imageName: String?) {
        this.imagePath = imagePath
        this.imageName = imageName
    }
    constructor()
    {}
}