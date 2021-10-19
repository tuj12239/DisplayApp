package edu.temple.displayapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val selectedImage: MutableLiveData<ImageClass> by lazy {
        MutableLiveData<ImageClass>()
    }

    fun getSelectedImage(): LiveData<ImageClass> {
        return selectedImage
    }

    fun setSelectedImage(imageClass: ImageClass) {
        selectedImage.value = imageClass
    }

}