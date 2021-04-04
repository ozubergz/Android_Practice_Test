package com.example.android_practice_test.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_practice_test.databinding.FragmentShoppingBinding

class ShoppingFragment : Fragment() {

    private lateinit var binding: FragmentShoppingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentShoppingBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

}