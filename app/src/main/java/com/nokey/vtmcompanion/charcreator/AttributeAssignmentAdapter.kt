package com.nokey.vtmcompanion.charcreator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nokey.vtmcompanion.R
import com.nokey.vtmcompanion.data.Attributes
import com.nokey.vtmcompanion.databinding.AttributeItemBinding
import com.nokey.vtmcompanion.ext.requireContext

class AttributeAssignmentAdapter :
    RecyclerView.Adapter<AttributeViewHolder>() {
    var attributes = Attributes.values()
    var attributeViews = arrayListOf<AttributeViewHolder>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributeViewHolder {
        val binding =
            AttributeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AttributeViewHolder(binding, ::setAttribute)
    }

    override fun getItemCount(): Int = attributes.size

    override fun onBindViewHolder(holder: AttributeViewHolder, position: Int) {
        if (attributeViews.size > position) attributeViews[position] = holder
        else attributeViews.add(holder)
        holder.bind(
            when (position) {
                0 -> 4 // One at 4 dots
                1, 2, 3 -> 3 // 3 at 3 dots
                4, 5, 6, 7 -> 2 // 4 at 2 dots
                else -> 1 // one at one dot
            }, position
        )
    }

    private fun setAttribute(
        newAttribute: Attributes,
        oldAttribute: Attributes
    ) {
        for (attributeView: AttributeViewHolder in attributeViews) {
            if (attributeView.attribute == newAttribute) {
                attributeView.updateAttribute(oldAttribute)
            }
        }
    }

    fun applyAttributes(updateAttributes: Map<Attributes, Short>) {
        attributes = updateAttributes
            .toList()
            .sortedBy { it.second }
            .map { it.first }
            .toTypedArray()
        for ((index, view: AttributeViewHolder) in attributeViews.withIndex()) {
            view.updateAttribute(attributes[index])
        }
    }
}

class AttributeViewHolder(
    private val binding: AttributeItemBinding,
    private val selectionUpdateListener: (Attributes, Attributes) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {
    lateinit var attribute: Attributes
    var dots: Short = 0
    fun bind(numberDots: Short, position: Int) {
        dots = numberDots
        val arrayAdapter = AttributeSpinnerAdapter(binding.requireContext())
        binding.apply {
            attributeName.text = binding.requireContext().getString(R.string.dots, numberDots)
            attributeSpinner.setAdapter(arrayAdapter)
            attributeSpinner.selectedIndex = position
            attribute = attributeSpinner.getItems<Attributes>()[position].also {
                it.dotsAssigned = dots
            }
            attributeSpinner.setOnItemSelectedListener { _, _, _, item ->
                val selectedAttribute = item as Attributes
                selectionUpdateListener(selectedAttribute, attribute)
                attribute = selectedAttribute
                item.dotsAssigned = dots
            }
        }
    }

    fun updateAttribute(oldAttribute: Attributes) {
        binding.attributeSpinner.apply {
            selectedIndex = getItems<Attributes>().indexOf(oldAttribute)
            attribute = getItems<Attributes>()[selectedIndex].also {
                it.dotsAssigned = dots
            }
        }
    }
}
