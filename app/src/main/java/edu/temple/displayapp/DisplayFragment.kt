package edu.temple.displayapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class DisplayFragment : Fragment() {
    lateinit var layout: View
    lateinit var label: TextView
    lateinit var image: ImageView

    companion object {
        fun newInstance() = DisplayFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_display, container, false)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        label = layout.findViewById(R.id.imageName)
        image = layout.findViewById(R.id.imageView)

        ViewModelProvider(requireActivity())
            .get(SharedViewModel::class.java)
            .getSelectedImage()
            .observe(viewLifecycleOwner, {updateDisplay()})
    }

    private fun updateDisplay() {
        val imageClass = ViewModelProvider(requireActivity())
                            .get(SharedViewModel::class.java)
                            .getSelectedImage()

        label.text = imageClass.value?.label
        image.setImageResource(imageClass.value!!.resource)

    }
}