package com.example.fragmentsandnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragmentsandnavigation.databinding.FragmentThirdBinding


class ThirdFragment : Fragment(R.layout.fragment_third) {

    private lateinit var binding:FragmentThirdBinding
    val args:ThirdFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        changeInfo()
        return binding.root
    }

    private fun changeInfo(){
        binding.confirmChangesBtn.setOnClickListener {
            val changeName = binding.changeFullName.text.toString()
            val changeAge = binding.changeAge.text.toString().toInt()
            val changeCountry = binding.changeCountry.text.toString()


            findNavController().navigate(ThirdFragmentDirections
                .actionThirdFragmentToSecondFragment(changeName,changeAge,changeCountry))
        }
    }

}