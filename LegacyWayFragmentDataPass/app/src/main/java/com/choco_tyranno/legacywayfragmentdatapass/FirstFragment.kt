package com.choco_tyranno.legacywayfragmentdatapass

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
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

    val getStartActivityForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){activityResult ->
        activityResult?.data?.let { intent->
            intent.extras?.let { bundle ->
                Toast.makeText(
                    requireContext(),
                    "result:${bundle.getString("data","No data")}"
                    , Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    val requestPermission = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){ granted ->
        if(granted) Toast.makeText(requireContext(),"권한 승인",Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firstButton = view.findViewById<Button>(R.id.first_button)

        firstButton.setOnClickListener {
            requestPermission.launch(Manifest.permission.ACCESS_FINE_LOCATION)

/*            Intent(requireContext(), ResultActivity::class.java).apply {
                getStartActivityForResult.launch(this)
            }*/

//            MIME TYPE
//            getContent.launch("image/*")


        }
    }

    companion object{
        private val TAG = FirstFragment::class.java.simpleName
    }
}