package com.disizaniknem.imgcalcul.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import com.disizaniknem.imgcalcul.repositories.ImgRepository

class ResultViewModel @ViewModelInject constructor(
    private val repository: ImgRepository
) {

    fun getAllResults() = repository.getAllResults()

}