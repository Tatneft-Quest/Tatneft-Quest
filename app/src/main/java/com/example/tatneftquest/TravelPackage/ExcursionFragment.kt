package com.example.tatneftquest.TravelPackage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tatneftquest.R
import com.example.tatneftquest.Fragments.BaseFragment

class ExcursionFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_excursion, container, false)
    }
}