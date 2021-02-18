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
import timber.log.Timber
import kotlin.math.pow
import kotlin.math.roundToInt

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
        val imgCalculated = calcul(poidsInt, tailleInt, ageInt, sexe)
        Timber.d(imgCalculated.toString())
        val isGood = checkIfIsGood(imgCalculated, sexe)

        val imgResult = Img(
            System.currentTimeMillis(),
            imgCalculated.roundToInt().toString(),
            poidsInt,
            tailleInt,
            ageInt,
            isGood
        )

        viewModel.insert(imgResult)
    }

    /**
     * Calcul de l'IMG
     */
    private fun calcul(poids: Int, taille: Int, age: Int, sexe: Int): Float {
        val imc = poids.toFloat() / (taille.toFloat() / 100f).pow(2)
        Timber.d(imc.toString())
        return (1.2f * imc.toFloat()) + (0.23f * age.toFloat()) - (10.8f * sexe.toFloat()) - 5.4f
    }

    /**
     * On regarde si l'img est bon ou non
     */
    private fun checkIfIsGood(imgCalculated: Float, sexe: Int): Boolean {
        var result = true
        if (sexe == 1 && (imgCalculated < 10 || imgCalculated > 25)) {
            result = false
        } else if (sexe == 0 && (imgCalculated < 20 || imgCalculated > 35)) {
            result = false
        }
        return result
    }
}