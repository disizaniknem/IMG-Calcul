package com.disizaniknem.imgcalcul.repositories

import com.disizaniknem.imgcalcul.data.ImgDao
import com.disizaniknem.imgcalcul.data.entities.Img
import javax.inject.Inject

class ImgRepository @Inject constructor(
    private val imgDao: ImgDao
) {

    suspend fun insert(img: Img) = imgDao.insert(img)

    suspend fun delete(img: Img) = imgDao.delete(img)

    fun getAllResults() = imgDao.getAllResults()

}