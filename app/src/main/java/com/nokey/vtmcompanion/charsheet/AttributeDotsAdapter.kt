package com.nokey.vtmcompanion.charsheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nokey.vtmcompanion.data.Attributes
import com.nokey.vtmcompanion.databinding.AttributeDotsItemBinding

class AttributeDotsAdapter() :
    RecyclerView.Adapter<AttributeDotsViewHolder>() {
    private var attributes: List<Attributes> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributeDotsViewHolder {
        val binding =
            AttributeDotsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AttributeDotsViewHolder(binding)
    }

    override fun getItemCount(): Int = attributes.size

    override fun onBindViewHolder(holder: AttributeDotsViewHolder, position: Int) {
        holder.bind(attributes[position])
    }

    fun setAttributes(attributes: List<Attributes>) {
        this.attributes = attributes
        notifyDataSetChanged()
    }
}

class AttributeDotsViewHolder(private val binding: AttributeDotsItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(attribute: Attributes) {
        binding.attributeDots.setDots(attribute.dotsAssigned)
        binding.attributeName.setText(attribute.nameRes)
    }
}