package com.disizaniknem.imgcalcul.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.disizaniknem.imgcalcul.repositories.ImgRepository

class ResultViewModel @ViewModelInject constructor(
    private val repository: ImgRepository
) : ViewModel() {

    fun getAllResults() = repository.getAllResults()

}