package com.nokey.vtmcompanion.charcreator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nokey.vtmcompanion.data.Clan
import com.nokey.vtmcompanion.databinding.ClanSelectionItemBinding

class ClanSelectionAdapter(private val onClanClicked: (Clan) -> Unit) : RecyclerView.Adapter<ClanSelectionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClanSelectionViewHolder {
        val binding =
            ClanSelectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClanSelectionViewHolder(binding, onClanClicked)
    }

    override fun getItemCount(): Int = Clan.values().size

    override fun onBindViewHolder(holder: ClanSelectionViewHolder, position: Int) {
        holder.bind(Clan.values()[position])
    }
}

class ClanSelectionViewHolder(
    private val binding: ClanSelectionItemBinding,
    private val onClanClicked: (Clan) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(clan: Clan) {
        binding.apply {
            clanName.setText(clan.stringRes)
            clanButton.setOnClickListener {
                onClanClicked(clan)
            }
        }
    }
}