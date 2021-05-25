package com.example.recyclerviewex.code

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import com.example.recyclerviewex.R
import com.example.recyclerviewex.databinding.FragmentImagesBinding
import com.example.recyclerviewex.databinding.FragmentUsersBinding

class UsersFragment : Fragment(){

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

     private fun onClick() {
         binding.fab.setOnClickListener {
             showDialog()
         }
    }

    private fun showDialog() {

        AddUserDialog().show(childFragmentManager, "MyCustomFragment")
    }
}