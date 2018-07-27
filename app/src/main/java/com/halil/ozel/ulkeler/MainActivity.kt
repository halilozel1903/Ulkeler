package com.halil.ozel.ulkeler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tumUlkeler = ArrayList<Ulke>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynaginiDoldur()

        var myAdapter = UlkelerRecyclerViewAdapter(tumUlkeler)
        recyclerviewDostlar.adapter = myAdapter


        var myLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        recyclerviewDostlar.layoutManager = myLayoutManager

    }

    private fun veriKaynaginiDoldur() {

        var resimler = arrayOf(R.drawable.albania,R.drawable.andorra,
                R.drawable.austria,R.drawable.belarus,R.drawable.belgium,
                R.drawable.bosnia)

        var isimler = arrayOf("Arnavutluk","Andorra","Avusturya","Belarus","Belçika","BosnaHersek")


        for (i in 0..resimler.size-1){

            var eklenecekUlke = Ulke(isimler[i],resimler[i])
            tumUlkeler.add(eklenecekUlke)

        }


    }
}
