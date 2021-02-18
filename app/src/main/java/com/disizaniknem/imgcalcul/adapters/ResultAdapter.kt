package com.disizaniknem.imgcalcul.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.disizaniknem.imgcalcul.R
import com.disizaniknem.imgcalcul.data.entities.Img
import kotlinx.android.synthetic.main.item_result.view.*
import java.text.SimpleDateFormat
import java.util.*

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ImgViewHolder>() {

    inner class ImgViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<Img>() {
        override fun areItemsTheSame(oldItem: Img, newItem: Img): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Img, newItem: Img): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var results: List<Img>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImgViewHolder {
        return ImgViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_result,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: ImgViewHolder, position: Int) {
        val result = results[position]
        holder.itemView.apply {
            tvImg.text = "IMG : ${result.result} %"

            ivIsGood.setImageResource(
                if (result.isGood) R.drawable.ic_good else R.drawable.ic_bad
            )

            val dateFormat = SimpleDateFormat("dd/MM/yy, HH:mm", Locale.getDefault())
            val dateString = dateFormat.format(result.date)
            tvDate.text = dateString
        }
    }
}