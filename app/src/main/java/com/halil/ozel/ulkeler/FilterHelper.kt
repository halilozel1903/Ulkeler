package com.halil.ozel.ulkeler

import android.widget.Filter

class FilterHelper(tumUlkeler:ArrayList<Ulke>,adapter:UlkelerRecyclerViewAdapter):Filter() {

    var suankiListe = tumUlkeler
    var suankiAdapter = adapter

    override fun performFiltering(p0: CharSequence?): FilterResults {

        var sonuc = FilterResults()

        if (p0 != null && p0.length>0){
            var aranilanAd = p0.toString().toLowerCase()
            var eslesenler = ArrayList<Ulke>()

            for (ulke in suankiListe){
                var adi = ulke.isim.toLowerCase()

                if (adi.contains(aranilanAd.toString())){
                    eslesenler.add(ulke)
                }

            }

            sonuc.values = eslesenler
            sonuc.count = eslesenler.size

        }else{

            sonuc.values = suankiListe
            sonuc.count = suankiListe.size
        }

        return sonuc
    }

    override fun publishResults(p0: CharSequence?, p1: FilterResults?) {

        suankiAdapter.setFilter(p1?.values as ArrayList<Ulke>)
        suankiAdapter.notifyDataSetChanged()

    }
}