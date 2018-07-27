package com.halil.ozel.ulkeler

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.tek_uye.view.*

class UlkelerRecyclerViewAdapter(tumUlkeler : ArrayList<Ulke>) : RecyclerView.Adapter<UlkelerRecyclerViewAdapter.UlkeViewHolder>() {

    var ulkeler = tumUlkeler

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): UlkeViewHolder {

        var inflater = LayoutInflater.from(p0?.context)
        var tek_uye = inflater.inflate(R.layout.tek_uye,p0,false)

        return UlkeViewHolder(tek_uye)
    }

    override fun getItemCount(): Int {

        return ulkeler.size
    }

    override fun onBindViewHolder(p0: UlkeViewHolder, p1: Int) {

        var oAnOlusturulanUlke = ulkeler.get(p1)
        p0?.setData(oAnOlusturulanUlke,p1)

    }

    class UlkeViewHolder(tek_uye: View) : RecyclerView.ViewHolder(tek_uye) {
        fun setData(oAnOlusturulanUlke: Ulke, p1: Int) {

            ulkeAd.text = oAnOlusturulanUlke.isim
            ulkeResim.setImageResource(oAnOlusturulanUlke.resim)

        }

        var tekUlkeBilgisi = tek_uye as CardView

        var ulkeAd = tekUlkeBilgisi.tvDostAdi
        var ulkeResim = tekUlkeBilgisi.imgDost

    }
}