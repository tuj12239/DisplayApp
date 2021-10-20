package edu.temple.displayapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KFunction1


class ImageAdapter(_context: Context, _images: Array<ImageClass>, _vocl: View.OnClickListener) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private val context = _context
    private val images = _images
    private val inflater = LayoutInflater.from(context)
    private val vocl = _vocl

    class ViewHolder(_view: View) : RecyclerView.ViewHolder(_view) {
        val view = _view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.imageview, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gridImage = holder.view.findViewById<ImageView>(R.id.gridImage)
        gridImage.setImageResource(images[position].resource)
        gridImage.setOnClickListener(vocl)
    }

    override fun getItemCount(): Int {
        return images.size
    }

}