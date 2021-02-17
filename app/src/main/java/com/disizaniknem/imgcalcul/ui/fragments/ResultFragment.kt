package com.disizaniknem.imgcalcul.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.disizaniknem.imgcalcul.R
import com.disizaniknem.imgcalcul.ui.BaseFragment
import com.disizaniknem.imgcalcul.ui.viewmodels.ResultViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : BaseFragment(R.layout.fragment_result) {

    private val viewModel: ResultViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToObservers()
    }

    private fun subscribeToObservers() {
        viewModel.getAllResults().observe(viewLifecycleOwner, Observer {

        })
    }

}