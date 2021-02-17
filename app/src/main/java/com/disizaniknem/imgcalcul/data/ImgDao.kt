package com.disizaniknem.imgcalcul.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.disizaniknem.imgcalcul.data.entities.Img

@Dao
interface ImgDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(img: Img)

    @Delete
    suspend fun delete(img: Img)

    @Query("SELECT * FROM table_img ORDER BY date DESC")
    fun getAllResults() : LiveData<List<Img>>

}