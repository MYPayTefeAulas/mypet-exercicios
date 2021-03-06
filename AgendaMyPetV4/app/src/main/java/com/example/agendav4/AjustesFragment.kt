package com.example.agendav4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.agendav4.databinding.FragmentAjustesBinding

class AjustesFragment(): Fragment() {

    private var _binding: FragmentAjustesBinding? = null

    private val binding get () = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAjustesBinding.inflate(inflater,container,false)

        return binding.root
    }
}