package com.halil.ozel.ulkeler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var intent = intent

        if (intent != null){
            tvDetay.text = intent.getStringExtra("name")
            tvUlkeBaskent.text = intent.getStringExtra("city")
            tvUlkePhone.text = intent.getStringExtra("phone")
            tvUlkePara.text = intent.getStringExtra("money")
            tvUlkeDil.text = intent.getStringExtra("language")
            tvUlkeKita.text = intent.getStringExtra("continent")
            imgDetay.setImageResource(intent.getIntExtra("image",0))
        }

    }
}
