package edu.temple.displayapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionFragment(_images: Array<ImageClass>) : Fragment() {

    private val images = _images
    lateinit var layout: View
    lateinit var gridView: RecyclerView

    companion object {
        fun newInstance(images: Array<ImageClass>) = SelectionFragment(images)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layout = inflater.inflate(R.layout.selection_fragment, container, false)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gridView = layout.findViewById(R.id.gridView)
        gridView.layoutManager = GridLayoutManager(requireContext(), 3)
        val adapter = ImageAdapter(requireContext(), images)
            { updateModel(gridView.indexOfChild(it.parent as View)) }

        gridView.adapter = adapter
        updateModel(0)
    }

    private fun updateModel(index: Int) {
        ViewModelProvider(requireActivity())
            .get(SharedViewModel::class.java)
            .setSelectedImage(images[index])
    }
}