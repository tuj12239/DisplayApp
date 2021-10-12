package edu.temple.displayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.main_activity_name)

        val images = getImageArray()

        val gridView = findViewById<RecyclerView>(R.id.gridView)
        val adapter = ImageAdapter(this, images)

        gridView.layoutManager = GridLayoutManager(this, 3)
        gridView.adapter = adapter

    }

    private fun getImageArray(): Array<ImageClass> {

        return arrayOf(
            ImageClass("Donphan", R.drawable.brazil),
            ImageClass("Dunsparce", R.drawable.canada),
            ImageClass("Eevee", R.drawable.france),
            ImageClass("Gengar", R.drawable.germany),
            ImageClass("Heracross", R.drawable.ireland),
            ImageClass("Magikarp", R.drawable.japan),
            ImageClass("Magnezone", R.drawable.mexico),
            ImageClass("Medicham", R.drawable.phillippines),
            ImageClass("Mudkip", R.drawable.southkorea),
            ImageClass("Murkrow", R.drawable.spain),
            ImageClass("Prinplup", R.drawable.unitedkingdom),
            ImageClass("Quagsire", R.drawable.unitedstates)
        )
    }
}