package com.nokey.vtmcompanion.charcreator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nokey.vtmcompanion.data.Attributes
import com.nokey.vtmcompanion.data.getAttributeOfType
import com.nokey.vtmcompanion.databinding.AttributeItemBinding
import com.nokey.vtmcompanion.ext.requireContext
import kotlinx.android.synthetic.main.attribute_item.view.*
import timber.log.Timber

class AttributeAssignmentAdapter :
    RecyclerView.Adapter<AttributeViewHolder>() {
    var attributes = Attributes.values().toList()
    private var attributeViews = arrayListOf<AttributeViewHolder>()

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
            }
        )
    }

    private fun setAttribute(attribute: Attributes, oldAttribute: Attributes?, dots: Int) {
        val previouslyAssignedDots = attributes.getAttributeOfType(attribute)?.dotsAssigned ?: 0
        attributes.getAttributeOfType(attribute)?.dotsAssigned = dots
        Timber.d("$attribute has been assigned $dots")
        oldAttribute?.let {
            if (previouslyAssignedDots > 0) {
                attributes.getAttributeOfType(it)?.dotsAssigned = previouslyAssignedDots
            }
        }
    }
}

class AttributeViewHolder(
    private val binding: AttributeItemBinding,
    private val selectionUpdateListener: (Attributes, Attributes?, Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {
    var attribute: Attributes? = null
    var dots: Int = 0
    fun bind(numberDots: Int) {
        dots = numberDots
        val arrayAdapter = AttributeSpinnerAdapter(binding.requireContext())
        binding.apply {
            dotsView.setDots(dots)
            attributeSpinner.auto_complete_view.apply {
                setAdapter(arrayAdapter)
                setOnItemClickListener { _, _, position, _ ->
                    val selectedAttribute = Attributes.values()[position]
                    setText(context.getText(selectedAttribute.nameRes), false)
                    selectionUpdateListener(selectedAttribute, attribute, dots)
                    attribute = selectedAttribute
                }
            }
        }
    }
}
