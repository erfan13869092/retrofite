package com.example.myapplication.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, var name: String
):Parcelable