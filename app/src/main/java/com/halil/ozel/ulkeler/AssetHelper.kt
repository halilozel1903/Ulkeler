package com.halil.ozel.ulkeler

/**
 * Created by halilozel1903 on 20.06.2025.
 */
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object AssetHelper {

    fun okuUlkeleri(context: Context): List<Ulke> {
        val json = context.assets.open("ulkeler.json").bufferedReader().use { it.readText() }
        val type = object : TypeToken<List<Ulke>>() {}.type
        return Gson().fromJson(json, type)
    }
}
