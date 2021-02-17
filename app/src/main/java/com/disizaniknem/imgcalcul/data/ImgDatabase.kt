package com.disizaniknem.imgcalcul.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.disizaniknem.imgcalcul.data.entities.Img

@Database(entities = [Img::class], version = 1)
abstract class ImgDatabase : RoomDatabase() {

    abstract fun imgDao(): ImgDao

}