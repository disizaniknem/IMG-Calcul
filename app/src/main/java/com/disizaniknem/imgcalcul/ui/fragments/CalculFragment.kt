package com.disizaniknem.imgcalcul.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.disizaniknem.imgcalcul.R
import com.disizaniknem.imgcalcul.ui.viewmodels.CalculViewModel
import dagger.hilt.android.AndroidEntryPoint

class CalculFragment : Fragment(R.layout.fragment_calcul) {

    private val viewModel: CalculViewModel by viewModels()

}