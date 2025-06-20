package com.halil.ozel.ulkeler

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.halil.ozel.ulkeler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UlkeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // JSON'dan ülke listesini oku
        val ulkeListesi = AssetHelper.okuUlkeleri(this)

        // Adapter'ı oluştur - tıklanınca DetayActivity'ye git
        adapter = UlkeAdapter(ulkeListesi) { secilenUlke ->
            val intent = Intent(this, DetayActivity::class.java)
            intent.putExtra("ulke", secilenUlke)
            startActivity(intent)
        }

        // RecyclerView ayarları
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}
