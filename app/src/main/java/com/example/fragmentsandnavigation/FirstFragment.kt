package com.example.fragmentsandnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragmentsandnavigation.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        getData()
        return binding.root
    }

    fun getData(){
        binding.confirmBtn.setOnClickListener {
            val pName = binding.fulName.text.toString()
            val pAge = binding.Age.text.toString().toInt()
            val pCountry = binding.Country.text.toString()

            findNavController().navigate(FirstFragmentDirections
                .actionFirstFragmentToSecondFragment(pName, pAge, pCountry))

        }
    }

}

