package com.nokey.vtmcompanion.charcreator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.nokey.vtmcompanion.R
import com.nokey.vtmcompanion.data.Attributes

class AttributeSpinnerAdapter(context: Context) :
    ArrayAdapter<Attributes>(context, R.layout.custom_spinner_item, Attributes.values()) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = convertView ?: inflater.inflate(R.layout.custom_spinner_item, null)
        view.findViewById<TextView>(R.id.name).setText(Attributes.values()[position].nameRes)
        return view
    }
}
