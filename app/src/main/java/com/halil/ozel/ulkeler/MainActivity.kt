package com.halil.ozel.ulkeler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.Menu
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//, SearchView.OnQueryTextListener{


    lateinit var myAdapter : UlkelerRecyclerViewAdapter



    var tumUlkeler = ArrayList<Ulke>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynaginiDoldur()

         myAdapter = UlkelerRecyclerViewAdapter(tumUlkeler)
        recyclerviewDostlar.adapter = myAdapter


        var myLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        recyclerviewDostlar.layoutManager = myLayoutManager

        searchViewDost.setOnQueryTextListener(object : android.support.v7.widget.SearchView.OnQueryTextListener{


            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
               myAdapter.filter.filter(p0)

                return false
            }

        })

    }

/*
    override fun onQueryTextSubmit(p0: String?): Boolean {
       return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {

        var girilenVeri = p0?.toLowerCase()
        var arananlar = ArrayList<Ulke>()

        for (ulke in tumUlkeler){

            var adi = ulke.isim.toLowerCase()

            if (adi.contains(girilenVeri.toString())){

                arananlar.add(ulke)

            }
        }

        myAdapter.setFilter(arananlar)

        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.filtre_menu,menu)

        var aramaItem = menu?.findItem(R.id.app_bar_search)

        var searchView = aramaItem?.actionView as? SearchView

        searchView?.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }
    */

    private fun veriKaynaginiDoldur() {

        var resimler = arrayOf(R.drawable.albania,R.drawable.andorra,
                R.drawable.austria,R.drawable.argentina,R.drawable.belarus,R.drawable.belgium,
                R.drawable.bosnia,R.drawable.brazil)

        var isimler = arrayOf("Arnavutluk","Andorra","Avusturya","Arjantin","Belarus","Belçika","BosnaHersek","Brezilya")


        for (i in 0..resimler.size-1){

            var eklenecekUlke = Ulke(isimler[i],resimler[i])
            tumUlkeler.add(eklenecekUlke)

        }


    }
}
