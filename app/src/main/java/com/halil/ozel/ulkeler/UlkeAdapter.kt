package com.halil.ozel.ulkeler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.halil.ozel.ulkeler.databinding.ItemUlkeBinding

class UlkeAdapter(
    private val ulkeListesi: List<Ulke>,
    private val onItemClick: (Ulke) -> Unit
) : RecyclerView.Adapter<UlkeAdapter.UlkeViewHolder>() {

    inner class UlkeViewHolder(private val binding: ItemUlkeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ulke: Ulke) {
            binding.tvAdi.text = ulke.adi
            binding.tvBaskent.text = "Başkent: ${ulke.baskent}"
            binding.tvDil.text = "Dil: ${ulke.dil}"
            binding.tvYuzolcumu.text = "Yüzölçümü: ${ulke.yuzolcumu} km²"

            Glide.with(binding.root.context)
                .load("https://flagpedia.net/data/flags/w1160/${ulke.bayrakKodu}.webp")
                .into(binding.imgBayrak)

            binding.root.setOnClickListener {
                onItemClick(ulke)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UlkeViewHolder {
        val binding = ItemUlkeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UlkeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UlkeViewHolder, position: Int) {
        holder.bind(ulkeListesi[position])
    }

    override fun getItemCount(): Int = ulkeListesi.size
}
