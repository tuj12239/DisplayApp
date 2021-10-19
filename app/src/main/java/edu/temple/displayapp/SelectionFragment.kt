package edu.temple.displayapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionFragment(val images: Array<ImageClass>) : Fragment() {

    lateinit var layout: View
    lateinit var gridView: RecyclerView
    private val viewModel: SharedViewModel by activityViewModels()

    companion object {
        fun newInstance(images: Array<ImageClass>) = SelectionFragment(images)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layout = inflater.inflate(R.layout.selection_fragment, container, false)
        return layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        gridView = layout.findViewById<RecyclerView>(R.id.gridView)
        val adapter = ImageAdapter(requireContext(), images)

        gridView.layoutManager = GridLayoutManager(requireContext(), 3)
        gridView.adapter = adapter
    }

}