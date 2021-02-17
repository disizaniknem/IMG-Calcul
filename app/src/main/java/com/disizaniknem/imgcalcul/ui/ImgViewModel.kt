package com.disizaniknem.imgcalcul.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.disizaniknem.imgcalcul.data.entities.Img
import com.disizaniknem.imgcalcul.repositories.ImgRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ImgViewModel @ViewModelInject constructor(
    private val repository: ImgRepository
) : ViewModel() {

    fun getAllResults() = repository.getAllResults()

    fun delete(imgId: String) = GlobalScope.launch {
        repository.delete(imgId)
    }

    fun insert(img: Img) = GlobalScope.launch {
        repository.insert(img)
    }

}