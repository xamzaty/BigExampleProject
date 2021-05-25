package com.example.recyclerviewex.code

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.NavController
import com.example.recyclerviewex.R
import com.example.recyclerviewex.databinding.FragmentCalculatorBinding
import com.example.recyclerviewex.databinding.FragmentUsersBinding

class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addAction()
    }

    private fun addAction() {
        binding.numberNull.setOnClickListener { vibrateDevice(requireContext()) }
        binding.numberOne.setOnClickListener { vibrateDevice(requireContext()) }
        binding.numberTwo.setOnClickListener { vibrateDevice(requireContext()) }
        binding.numberThree.setOnClickListener { vibrateDevice(requireContext()) }
        binding.numberFour.setOnClickListener { vibrateDevice(requireContext()) }
        binding.numberFive.setOnClickListener { vibrateDevice(requireContext()) }
        binding.numberSix.setOnClickListener { vibrateDevice(requireContext()) }
        binding.numberSeven.setOnClickListener { vibrateDevice(requireContext()) }
        binding.numberEight.setOnClickListener { vibrateDevice(requireContext()) }
        binding.numberNine.setOnClickListener { vibrateDevice(requireContext()) }
    }

    private fun vibrateDevice(context: Context) {
        val vibrator = getSystemService(context, Vibrator::class.java)
        vibrator?.let {
            if (Build.VERSION.SDK_INT >= 26) {
                it.vibrate(VibrationEffect.createOneShot(30, 40))
            } else {
                @Suppress("DEPRECATION")
                it.vibrate(100)
            }
        }
    }
}