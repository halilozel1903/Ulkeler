package com.halil.ozel.ulkeler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.halil.ozel.ulkeler.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ulke = intent.getParcelableExtra<Ulke>("ulke") ?: return

        binding.tvAdi.text = ulke.adi
        binding.tvBaskent.text = "Başkent: ${ulke.baskent}"
        binding.tvDil.text = "Dil: ${ulke.dil}"
        binding.tvYuzolcumu.text = "Yüzölçümü: ${ulke.yuzolcumu} km²"

        // Bayrak yükle (Flagpedia'dan)
        Glide.with(this)
            .load("https://flagpedia.net/data/flags/w1160/${ulke.bayrakKodu}.webp")
            .into(binding.imgBayrak)
    }
}
