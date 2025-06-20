package com.halil.ozel.ulkeler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.halil.ozel.ulkeler.databinding.ItemUlkeBinding

class UlkeAdapter(
    private val orijinalListe: List<Ulke>,
    private val onItemClick: (Ulke) -> Unit
) : RecyclerView.Adapter<UlkeAdapter.UlkeViewHolder>(), Filterable {


    private val filtrelenmisListe = mutableListOf<Ulke>().apply { addAll(orijinalListe) }

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

            binding.root.setOnClickListener { onItemClick(ulke) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UlkeViewHolder(ItemUlkeBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: UlkeViewHolder, position: Int) =
        holder.bind(filtrelenmisListe[position])

    override fun getItemCount(): Int = filtrelenmisListe.size

    override fun getFilter(): Filter {
        return object : Filter() {

            override fun performFiltering(query: CharSequence?): FilterResults {
                val filteredList: List<Ulke> = if (query.isNullOrBlank()) {
                    orijinalListe
                } else {
                    val filterText = query.toString().lowercase()
                    orijinalListe.filter { it.adi.lowercase().contains(filterText) }
                }

                return FilterResults().apply {
                    values = filteredList
                }
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(query: CharSequence?, results: FilterResults) {
                val resultList = results.values as? List<Ulke> ?: emptyList()

                filtrelenmisListe.clear()
                filtrelenmisListe.addAll(resultList)
                notifyDataSetChanged()
            }
        }
    }


}
