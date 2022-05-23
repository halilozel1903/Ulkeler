package com.halil.ozel.ulkeler

import android.annotation.SuppressLint
import android.widget.Filter
import java.util.*
import kotlin.collections.ArrayList

class FilterHelper(tumUlkeler: ArrayList<Ulke>, adapter: UlkelerRecyclerViewAdapter) : Filter() {

    var suankiListe = tumUlkeler
    var suankiAdapter = adapter

    override fun performFiltering(p0: CharSequence?): FilterResults {

        val sonuc = FilterResults()

        if (p0 != null && p0.isNotEmpty()) {
            val aranilanAd = p0.toString().toLowerCase(Locale.ROOT)
            val eslesenler = ArrayList<Ulke>()

            for (ulke in suankiListe) {
                val adi = ulke.isim.toLowerCase(Locale.ROOT)
                if (adi.contains(aranilanAd)) {
                    eslesenler.add(ulke)
                }
            }

            sonuc.values = eslesenler
            sonuc.count = eslesenler.size

        } else {
            sonuc.values = suankiListe
            sonuc.count = suankiListe.size
        }

        return sonuc
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
        suankiAdapter.setFilter(p1?.values as ArrayList<Ulke>)
        suankiAdapter.notifyDataSetChanged()
    }
}