package com.nokey.vtmcompanion.charcreator

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nokey.vtmcompanion.R
import com.nokey.vtmcompanion.data.Attributes
import com.nokey.vtmcompanion.databinding.AttributeItemBinding

class AttributeAssignmentAdapter: RecyclerView.Adapter<AttributeViewHolder>() {
    private lateinit var attributes: Array<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributeViewHolder {
        val binding = AttributeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        attributes = parent.context.resources.getStringArray(R.array.attributes)
        return AttributeViewHolder(binding)
    }

    override fun getItemCount(): Int = Attributes.values().size

    override fun onBindViewHolder(holder: AttributeViewHolder, position: Int) {
        holder.bind(attributes[position])
    }
}

class AttributeViewHolder(private val binding: AttributeItemBinding): RecyclerView.ViewHolder(binding.root) {
    private val numbers = listOf(4, 3, 2, 1)

    fun bind(attribute: String) {
        binding.attributeName.text = attribute
        binding.attributeSpinner.setAdapter(ArrayAdapter<Int>(binding.root.context, android.R.layout.simple_spinner_dropdown_item, numbers))
    }
}