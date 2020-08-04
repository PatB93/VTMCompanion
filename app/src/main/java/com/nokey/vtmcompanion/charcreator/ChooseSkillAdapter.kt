package com.nokey.vtmcompanion.charcreator

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nokey.vtmcompanion.R
import com.nokey.vtmcompanion.data.Balanced
import com.nokey.vtmcompanion.data.SkillDistributions
import com.nokey.vtmcompanion.databinding.ChooseSkillItemBinding
import com.nokey.vtmcompanion.ext.requireContext

class ChooseSkillAdapter : RecyclerView.Adapter<SkillViewHolder>() {
    var skillDistribution: SkillDistributions = Balanced()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val binding =
            ChooseSkillItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SkillViewHolder(binding)
    }

    override fun getItemCount(): Int {
        skillDistribution.apply {
            return fourDotSkills.size + threeDotSkills.size + twoDotSkills.size + oneDotSkills.size
        }
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        val fourDot = skillDistribution.fourDotSkills.size
        val threeDot = skillDistribution.threeDotSkills.size
        val twoDot = skillDistribution.twoDotSkills.size
        val oneDot = skillDistribution.oneDotSkills.size
        when {
            position <= fourDot -> holder.bind(4)
            position <= threeDot + fourDot -> holder.bind(3)
            position <= twoDot + fourDot + threeDot -> holder.bind(2)
            position <= oneDot + fourDot + threeDot + twoDot -> holder.bind(1)
        }
    }
}

class SkillViewHolder(private val binding: ChooseSkillItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(dots: Int) {
        binding.apply {
            dotsIndicator.text = binding.requireContext().getString(R.string.dots, dots)
            skillSpinner.setAdapter(
                ArrayAdapter<String>(
                    binding.requireContext(),
                    android.R.layout.simple_spinner_dropdown_item,
                    binding.requireContext().resources.getStringArray(R.array.skills)
                )
            )
        }
    }
}