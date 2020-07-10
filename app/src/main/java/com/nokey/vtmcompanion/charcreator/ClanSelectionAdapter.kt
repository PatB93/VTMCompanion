package com.nokey.vtmcompanion.charcreator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nokey.vtmcompanion.data.Clans
import com.nokey.vtmcompanion.databinding.ClanSelectionItemBinding

class ClanSelectionAdapter(private val onClanClicked: (Clans) -> Unit) : RecyclerView.Adapter<ClanSelectionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClanSelectionViewHolder {
        val binding =
            ClanSelectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClanSelectionViewHolder(binding, onClanClicked)
    }

    override fun getItemCount(): Int = Clans.values().size

    override fun onBindViewHolder(holder: ClanSelectionViewHolder, position: Int) {
        holder.bind(Clans.values()[position])
    }
}

class ClanSelectionViewHolder(
    private val binding: ClanSelectionItemBinding,
    private val onClanClicked: (Clans) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(clan: Clans) {
        binding.apply {
            clanName.setText(clan.stringRes)
            clanButton.setOnClickListener {
                onClanClicked(clan)
            }
        }
    }
}