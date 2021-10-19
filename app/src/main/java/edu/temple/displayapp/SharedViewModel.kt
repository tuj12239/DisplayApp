package edu.temple.displayapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val images: MutableLiveData<Array<ImageClass>> by lazy {
        MutableLiveData<Array<ImageClass>>()
    }

    private val selectedImage: MutableLiveData<ImageClass> by lazy {
        MutableLiveData<ImageClass>()
    }

    private fun loadImages(_images: Array<ImageClass>) {
        images.value = _images
        selectedImage.value = _images[0]
    }

    fun getImages(): LiveData<Array<ImageClass>> {
        return images
    }

    fun getSelectedImage(): LiveData<ImageClass> {
        return selectedImage
    }

}