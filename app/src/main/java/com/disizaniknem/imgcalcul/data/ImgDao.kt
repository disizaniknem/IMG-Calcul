package com.disizaniknem.imgcalcul.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.disizaniknem.imgcalcul.data.entities.Img

@Dao
interface ImgDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(img: Img)

    @Query("DELETE FROM table_img WHERE id = :imgId")
    suspend fun delete(imgId: String)

    @Query("SELECT * FROM table_img ORDER BY date DESC")
    fun getAllResults() : LiveData<List<Img>>

}