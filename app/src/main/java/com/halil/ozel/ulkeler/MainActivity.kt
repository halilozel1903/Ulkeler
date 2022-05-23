package com.halil.ozel.ulkeler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import android.view.Menu
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: UlkelerRecyclerViewAdapter
    var tumUlkeler = ArrayList<Ulke>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynaginiDoldur()

        myAdapter = UlkelerRecyclerViewAdapter(tumUlkeler)
        recyclerviewDostlar.adapter = myAdapter


        val myLayoutManager =
            StaggeredGridLayoutManager(
                2,
                StaggeredGridLayoutManager.VERTICAL
            )

        recyclerviewDostlar.layoutManager = myLayoutManager

        searchViewDost.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                myAdapter.filter.filter(p0)
                return false
            }

        })

    }

    private fun veriKaynaginiDoldur() {

        val resimler = arrayOf(
            R.drawable.albania, R.drawable.andorra,
            R.drawable.austria, R.drawable.argentina, R.drawable.belarus, R.drawable.belgium,
            R.drawable.bosnia, R.drawable.brazil
        )

        val isimler = arrayOf(
            "Arnavutluk",
            "Andorra",
            "Avusturya",
            "Arjantin",
            "Belarus",
            "Belçika",
            "BosnaHersek",
            "Brezilya"
        )

        for (i in 0..resimler.size - 1) {
            val eklenecekUlke = Ulke(isimler[i], resimler[i])
            tumUlkeler.add(eklenecekUlke)
        }
    }
}
