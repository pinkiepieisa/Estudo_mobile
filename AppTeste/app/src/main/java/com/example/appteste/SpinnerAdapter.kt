package com.example.appteste

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class SpinnerAdapter(
    context: Context,
    private val nomes: List<String>,
    private val imagens: IntArray
) : ArrayAdapter<String>(context, 0, nomes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return montarItem(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return montarItem(position, convertView, parent)
    }

    private fun montarItem(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_spinner, parent, false)

        val img = view.findViewById<ImageView>(R.id.imgItem)
        val txt = view.findViewById<TextView>(R.id.txtItem)

        img.setImageResource(imagens[position])
        txt.text = nomes[position]

        return view
    }
}