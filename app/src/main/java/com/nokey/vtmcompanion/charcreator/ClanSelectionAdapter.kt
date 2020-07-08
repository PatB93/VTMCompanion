package com.nokey.vtmcompanion.charcreator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nokey.vtmcompanion.databinding.ClanSelectionItemBinding

class ClanSelectionAdapter : RecyclerView.Adapter<ClanSelectionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClanSelectionViewHolder {
        val binding = ClanSelectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClanSelectionViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return 1 // TODO : Revisit once data is figured out
    }

    override fun onBindViewHolder(holder: ClanSelectionViewHolder, position: Int) {
        holder.bind()
    }

}

class ClanSelectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind() {

    }
}