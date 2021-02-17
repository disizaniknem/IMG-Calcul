package com.disizaniknem.imgcalcul.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "table_img")
data class Img(
    val date: Long,
    val result: String,
    val poids: Int,
    val taille: Int,
    val sexe: Int,
    val isGood: Boolean,
    @PrimaryKey(autoGenerate = false)
    var id: String = UUID.randomUUID().toString()
)