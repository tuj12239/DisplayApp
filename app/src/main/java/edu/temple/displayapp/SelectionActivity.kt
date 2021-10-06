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

    private fun launchDisplayAct(_imageclass: ImageClass) {

    }

    private fun getImageArray(): Array<ImageClass> {

        return arrayOf(
            ImageClass("Donphan", R.drawable.donphan),
            ImageClass("Dunsparce", R.drawable.dunsparce),
            ImageClass("Eevee", R.drawable.eevee),
            ImageClass("Gengar", R.drawable.gengar),
            ImageClass("Heracross", R.drawable.heracross),
            ImageClass("Magikarp", R.drawable.magikarp),
            ImageClass("Magnezone", R.drawable.magnezone),
            ImageClass("Medicham", R.drawable.medicham),
            ImageClass("Mudkip", R.drawable.mudkip),
            ImageClass("Murkrow", R.drawable.murkrow),
            ImageClass("Prinplup", R.drawable.prinplup),
            ImageClass("Quagsire", R.drawable.quagsire)
        )
    }
}