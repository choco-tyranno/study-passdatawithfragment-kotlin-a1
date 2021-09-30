package com.choco_tyranno.legacywayfragmentdatapass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController

class FirstFragment : Fragment(R.layout.fragment_first) {
    val viewModel by activityViewModels<MainViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firstButton = view.findViewById<Button>(R.id.first_button)

        firstButton.setOnClickListener {
            setFragmentResult("requestKey"
                , bundleOf("data" to "Hi")
            )
            firstButton.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }
}