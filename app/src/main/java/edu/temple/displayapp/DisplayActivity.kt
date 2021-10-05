package edu.temple.displayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val name: String? = intent.getStringExtra("Name")
        val resource: Int? = intent.getIntExtra("Resource", 0)

        val label = findViewById<TextView>(R.id.textView)
        val image = findViewById<ImageView>(R.id.imageView)

        label.text = name
        if (resource != null) {
            image.setImageResource(resource)
        }
    }
}