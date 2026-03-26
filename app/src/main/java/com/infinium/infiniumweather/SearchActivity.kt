package com.infinium.infiniumweather

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class SearchActivity : AppCompatActivity() {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_dropdown_item_1line, cities)

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.countries_list)

        autoCompleteTextView.setAdapter(adapter)

        autoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            val selectedCity = cities[position]
            println("Ville sélectionnée : $selectedCity")
        }
    }
}