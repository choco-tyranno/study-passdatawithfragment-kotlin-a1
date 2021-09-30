package com.choco_tyranno.legacywayfragmentdatapass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController

class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val secondButton = view.findViewById<Button>(R.id.second_button)

        setFragmentResultListener("requestKey"){requestKey, bundle ->
            val data = bundle.getString("data","")
            Toast.makeText(requireContext(),data, Toast.LENGTH_SHORT).show()
        }

        secondButton.setOnClickListener {
            secondButton.findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }
}