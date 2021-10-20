package edu.temple.displayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.main_activity_name)

        ViewModelProvider(this)
            .get(SharedViewModel::class.java)
        val selectionFragment = SelectionFragment.newInstance(getImageArray())
        val displayFragment = DisplayFragment.newInstance()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, selectionFragment)
            .add(R.id.fragmentContainerView2, displayFragment)
            .commit()
    }

    private fun getImageArray(): Array<ImageClass> {
        val names: Array<String> = resources.getStringArray(R.array.flags)

        return arrayOf(
            ImageClass(names[0], R.drawable.brazil),
            ImageClass(names[1], R.drawable.canada),
            ImageClass(names[2], R.drawable.france),
            ImageClass(names[3], R.drawable.germany),
            ImageClass(names[4], R.drawable.ireland),
            ImageClass(names[5], R.drawable.japan),
            ImageClass(names[6], R.drawable.mexico),
            ImageClass(names[7], R.drawable.philippines),
            ImageClass(names[8], R.drawable.southkorea),
            ImageClass(names[9], R.drawable.spain),
            ImageClass(names[10], R.drawable.unitedkingdom),
            ImageClass(names[11], R.drawable.unitedstates)
        )
    }
}