package com.halil.ozel.ulkeler

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

        // JSON'dan veri oku
        val ulkeListesi = AssetHelper.okuUlkeleri(this)

        adapter = UlkeAdapter(ulkeListesi) { secilenUlke ->
            val intent = Intent(this, DetayActivity::class.java)
            intent.putExtra("ulke", secilenUlke)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter.filter(s?.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })


    }
}
