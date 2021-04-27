package com.example.nestedrecyclerswrapissue.mainList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerswrapissue.databinding.ListItemNormalItemBinding

class NormalViewHolder(binding: ListItemNormalItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind() {

    }

    companion object {
        fun create(parent: ViewGroup): NormalViewHolder {
            val binding =
                ListItemNormalItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            return NormalViewHolder(binding)
        }
    }
}