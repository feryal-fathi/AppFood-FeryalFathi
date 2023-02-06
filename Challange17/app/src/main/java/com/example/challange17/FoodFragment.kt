package com.example.challange17

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.challange17.databinding.FragmentFoodBinding
import com.example.recycleview.FoodAdapter


class FoodFragment : Fragment(R.layout.fragment_food) {
    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodBinding.bind(view)
        val pref=Mysharedpref(requireContext())


        val foodlist= mutableListOf(Food("Pizza",R.drawable.baseline_local_pizza_24),
            Food("Burger",R.drawable.lunch_dining_fill0_wght400_grad0_opsz48),
            Food("Croissant",R.drawable.bakery_dining_fill0_wght400_grad0_opsz48))
        val adapter= FoodAdapter()
        binding.tvFood.adapter=adapter
        adapter.submitList(foodlist)

        adapter.s= pref.getFontSize()!!
        binding.tvFood.adapter=adapter
        adapter.submitList(foodlist)

        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}