package com.disizaniknem.imgcalcul.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_img")
data class Img(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val date: Long,
    val result: String,
    val poids: Int,
    val taille: Int,
    val sexe: Int
)