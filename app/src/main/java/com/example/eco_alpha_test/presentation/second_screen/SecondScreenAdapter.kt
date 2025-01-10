package com.example.eco_alpha_test.presentation.second_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.eco_alpha_test.R
import com.example.eco_alpha_test.databinding.BinItemBinding
import com.example.eco_alpha_test.presentation.model.BINDetailUI

class SecondScreenAdapter :
    ListAdapter<BINDetailUI, SecondScreenViewHolder>(BINDetailItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondScreenViewHolder {
        val binding =
            BinItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SecondScreenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SecondScreenViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class SecondScreenViewHolder(private val binding: BinItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(detail: BINDetailUI) {
        binding.tvBinName.text =
            binding.root.context.getString(R.string.bin_name, detail.bin)
        binding.tvCountryName.text =
            binding.root.context.getString(R.string.country_name, detail.townName)
        binding.tvCordName.text =
            binding.root.context.getString(
                R.string.cord_name,
                detail.longitude.toString(),
                detail.latitude.toString()
            )
        binding.tvTypeCardName.text =
            binding.root.context.getString(R.string.type_card_name, detail.brand)
        binding.tvUrlName.text =
            binding.root.context.getString(R.string.url_name, detail.url)
        binding.tvPhoneNumber.text =
            binding.root.context.getString(R.string.phone_number, detail.phone)
        binding.tvSiteName.text =
            binding.root.context.getString(R.string.site_name, detail.name)
        binding.tvTownName.text =
            binding.root.context.getString(R.string.town_name, detail.city)
    }
}

class BINDetailItemDiffCallback : DiffUtil.ItemCallback<BINDetailUI>() {
    override fun areItemsTheSame(
        oldItem: BINDetailUI,
        newItem: BINDetailUI
    ): Boolean {
        return oldItem.bin == newItem.bin
    }

    override fun areContentsTheSame(
        oldItem: BINDetailUI,
        newItem: BINDetailUI
    ): Boolean {
        return oldItem == newItem
    }
}