package com.example.nestedrecyclerswrapissue.nestedList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerswrapissue.databinding.ListItemTypeBBinding

class TypeBViewHolder(private val binding: ListItemTypeBBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind() {
        binding.additionalTextView.isVisible = adapterPosition % 2 == 0
    }

    companion object {
        fun create(parent: ViewGroup): TypeBViewHolder {
            val binding =
                ListItemTypeBBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TypeBViewHolder(binding)
        }
    }
}