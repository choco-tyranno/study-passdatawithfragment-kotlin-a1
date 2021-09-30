package com.choco_tyranno.legacywayfragmentdatapass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController

class FirstFragment : Fragment(R.layout.fragment_first) {
    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()){uri ->
        val imageView = view?.findViewById<ImageView>(R.id.image)
        imageView?.setImageURI(uri)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firstButton = view.findViewById<Button>(R.id.first_button)

        firstButton.setOnClickListener {
            //MIME TYPE
            getContent.launch("image/*")
        }
    }
}