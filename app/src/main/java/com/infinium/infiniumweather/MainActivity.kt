package com.infinium.infiniumweather

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val cities = arrayOf(
        "Helsinki", "Espoo", "Tampere", "Vantaa", "Oulu",
        "Turku", "Jyväskylä", "Lahti", "Kuopio", "Pori",
        "Joensuu", "Vaasa", "Lappeenranta", "Hämeenlinna", "Rovaniemi",
        "Mikkeli", "Porvoo", "Kokkola", "Kotka", "Savonlinna",
        "Salo", "Rauma", "Kemi", "Kouvola", "Tornio",
        "Valkeakoski", "Riihimäki", "Lohja", "Järvenpää", "Nokia",
        "Kirkkonummi", "Varkaus", "Imatra", "Pieksämäki", "Korsholm",
        "Käki", "Kajaani", "Seinäjoki", "Kurikka", "Lieto",
        "Nurmijärvi", "Orimattila", "Siilinjärvi", "Tammela", "Uusikaupunki",
        "Äänekoski", "Alavus", "Eura", "Forssa", "Haapajärvi",
        "Haapavesi", "Hamina", "Hattula", "Heinola", "Humppila",
        "Iisalmi", "Ikaalinen", "Juva", "Kangasala", "Karkkila",
        "Kauhava", "Kemiönsaari", "Keuruu", "Korsnäs", "Kristinestad"
    )

    var searchLocationButton: Button? = null
    var citiesListRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        citiesListRecyclerView = findViewById<RecyclerView>(R.id.favorites_location_recyclerview)
        searchLocationButton = findViewById(R.id.search_location)

        citiesListRecyclerView?.layoutManager = LinearLayoutManager(this)
        citiesListRecyclerView?.adapter = FavoritesLocationRecyclerViewAdapter(cities)

        searchLocationButton?.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }
}