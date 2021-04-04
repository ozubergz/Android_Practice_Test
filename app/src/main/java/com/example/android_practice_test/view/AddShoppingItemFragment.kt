package com.example.android_practice_test.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_practice_test.databinding.FragmentAddShoppingItemBinding

class AddShoppingItemFragment : Fragment() {

    private lateinit var binding: FragmentAddShoppingItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentAddShoppingItemBinding.inflate(inflater, container, false).also {
        binding = it
    }.root
}