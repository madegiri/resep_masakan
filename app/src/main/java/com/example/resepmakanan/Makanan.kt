package com.example.resepmakanan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Makanan(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
