package com.example.recyclerviewex.code

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.example.recyclerviewex.R
import com.example.recyclerviewex.databinding.FragmentImagesBinding
import com.example.recyclerviewex.databinding.FragmentOptionsBinding

class ImagesFragment : Fragment() {

    private var _binding: FragmentImagesBinding? = null
    private val binding get() = _binding!!

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImagesBinding.inflate(inflater, container, false)
        return binding.root
    }
}