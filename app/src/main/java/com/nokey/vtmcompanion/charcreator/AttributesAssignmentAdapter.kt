package com.nokey.vtmcompanion.charcreator

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nokey.vtmcompanion.data.Attributes
import com.nokey.vtmcompanion.databinding.AttributeItemBinding

class AttributesAssignmentAdapter : RecyclerView.Adapter<AttributeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributeViewHolder {
        val binding =
            AttributeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AttributeViewHolder(binding)
    }

    override fun getItemCount(): Int = Attributes.values().size

    override fun onBindViewHolder(holder: AttributeViewHolder, position: Int) {
        holder.bind()
    }
}

class AttributeViewHolder(private val binding: AttributeItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind() {
        binding.attributeSpinner.apply {
            adapter = ArrayAdapter(
                binding.root.context,
                android.R.layout.simple_spinner_dropdown_item,
                Attributes.values()
            )

            
        }
    }
}