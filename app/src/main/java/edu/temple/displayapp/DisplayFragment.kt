package edu.temple.displayapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer

class DisplayFragment : Fragment() {
    lateinit var layout: View
    private val viewModel: SharedViewModel by activityViewModels()
    lateinit var label: TextView
    lateinit var image: ImageView

    companion object {
        fun newInstance() = DisplayFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_display, container, false)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        label = layout.findViewById<TextView>(R.id.imageName)
        image = layout.findViewById<ImageView>(R.id.imageView)


        viewModel.getSelectedImage().observe(viewLifecycleOwner, Observer<ImageClass> {
                image: ImageClass? ->
            if (image != null) {
                updateDisplay()
            }
        })
    }

    private fun updateDisplay() {
        label.text = viewModel.getSelectedImage().value!!.label
        image.setImageResource(viewModel.getSelectedImage().value!!.resource)

    }
}