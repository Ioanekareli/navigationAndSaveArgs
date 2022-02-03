package com.example.fragmentsandnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragmentsandnavigation.databinding.FragmentFirstBinding
import com.example.fragmentsandnavigation.databinding.FragmentSecondBinding


class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var binding: FragmentSecondBinding
    val args:SecondFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        setData()
        navigateToThirdFragment()
        setChangedInfo()
        return binding.root
    }

    private fun setData(){
        val age = args.age
        val name = args.name
        val country = args.country
        val person = Person(name,age,country)
        binding.personalInfo.setText(person.toString())
    }

    private fun navigateToThirdFragment(){
        binding.changeInfoBtn.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }

    private fun setChangedInfo(){
        val changedName = args.name
        val changedAge = args.age
        val changedCountry = args.country
        val changedPerson = Person(changedName,changedAge,changedCountry)

        binding.personalInfo.setText(changedPerson.toString())
    }

}