package com.example.challange17

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.challange17.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    var SizeLarge=24f
    var SizeMid=16f
    var SizeSmall=8f
    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)
        val pref=Mysharedpref(requireContext())


            binding.apply {
                binding.rbtnLarge.setOnClickListener {
                    SizeLarge = 24f
                    pref.saveFontSiza(SizeLarge)
                }
                    binding.rbtnMid.setOnClickListener {
                        SizeMid = 16f
                        pref.saveFontSiza(SizeMid)
                    }
                        binding.rbtnSmall.setOnClickListener {
                            SizeSmall= 8f
                            pref.saveFontSiza(SizeSmall)

                        }


    }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}