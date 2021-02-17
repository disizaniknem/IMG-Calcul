package com.disizaniknem.imgcalcul.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.disizaniknem.imgcalcul.R
import com.disizaniknem.imgcalcul.data.entities.Img
import com.disizaniknem.imgcalcul.ui.BaseFragment
import com.disizaniknem.imgcalcul.ui.ImgViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_calcul.*

@AndroidEntryPoint
class CalculFragment : BaseFragment(R.layout.fragment_calcul) {

    private val viewModel: ImgViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnCalcul.setOnClickListener {
            calculImg()
        }
    }

    private fun calculImg() {
        val poids = etPoids.text.toString()
        val taille = etTaille.text.toString()
        val age = etAge.text.toString()

        if (poids.isEmpty() || taille.isEmpty() || age.isEmpty()
            || (!rbHomme.isChecked && !rbFemme.isChecked)
        ) {
            showSnackbar("Remplir tous les champs")
            return
        }

        // Calcul
        val poidsInt = poids.toInt()
        val tailleInt = taille.toInt()
        val ageInt = age.toInt()
        val sexe = if (rbHomme.isChecked) 1 else 0
        val isGood = checkIfIsGood(poidsInt, tailleInt, ageInt, sexe)
        val imgCalculated = calcul(poidsInt, tailleInt, ageInt, sexe)

        val imgResult = Img(
            System.currentTimeMillis(),
            imgCalculated.toString(),
            poidsInt,
            tailleInt,
            ageInt,
            isGood
        )

        viewModel.insert(imgResult)
    }

    private fun calcul(poids: Int, taille: Int, age: Int, sexe: Int): Float {
        return 0f
    }

    private fun checkIfIsGood(poids: Int, taille: Int, age: Int, sexe: Int): Boolean {
        return true
    }
}