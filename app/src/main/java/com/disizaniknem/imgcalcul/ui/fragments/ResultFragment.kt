package com.disizaniknem.imgcalcul.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.disizaniknem.imgcalcul.R
import com.disizaniknem.imgcalcul.adapters.ResultAdapter
import com.disizaniknem.imgcalcul.ui.BaseFragment
import com.disizaniknem.imgcalcul.ui.ImgViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_result.*

@AndroidEntryPoint
class ResultFragment : BaseFragment(R.layout.fragment_result) {

    private val viewModel: ImgViewModel by viewModels()

    private lateinit var resultAdapter: ResultAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
        subscribeToObservers()
    }

    private fun setupRecycleView() = rvResult.apply {
        resultAdapter = ResultAdapter()
        adapter = resultAdapter
        layoutManager = LinearLayoutManager(requireContext())
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(this)
    }

    private fun subscribeToObservers() {
        viewModel.getAllResults().observe(viewLifecycleOwner, Observer {
            resultAdapter.results = it
        })
    }

    private val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
        0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
    ) {

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.layoutPosition
            val imgResult = resultAdapter.results[position]
            viewModel.delete(imgResult.id)
            Snackbar.make(requireView(), "Résultat supprimé", Snackbar.LENGTH_LONG).apply {
                setAction("Annuler")  {
                    viewModel.insert(imgResult)
                }
                show()
            }
        }
    }

}