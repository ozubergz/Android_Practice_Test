package com.example.android_practice_test.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_practice_test.databinding.FragmentImagePickBinding

class ImagePickFragment : Fragment() {

    private lateinit var binding: FragmentImagePickBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentImagePickBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    
}