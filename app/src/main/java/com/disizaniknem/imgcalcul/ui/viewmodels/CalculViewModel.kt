package com.disizaniknem.imgcalcul.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.disizaniknem.imgcalcul.data.entities.Img
import com.disizaniknem.imgcalcul.repositories.ImgRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CalculViewModel @ViewModelInject constructor(
    private val repository: ImgRepository
) : ViewModel() {

    fun insert(img: Img) = GlobalScope.launch {
        repository.insert(img)
    }

}