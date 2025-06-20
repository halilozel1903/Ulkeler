package com.halil.ozel.ulkeler

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ulke(
    val adi: String,
    val baskent: String,
    val yuzolcumu: Double,
    val dil: String,
    val bayrakKodu: String
) : Parcelable
