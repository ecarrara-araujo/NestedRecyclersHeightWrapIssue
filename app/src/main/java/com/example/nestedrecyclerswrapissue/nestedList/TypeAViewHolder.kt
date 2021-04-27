package com.example.nestedrecyclerswrapissue.nestedList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerswrapissue.databinding.ListItemTypeABinding

class TypeAViewHolder(binding: ListItemTypeABinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind() {

    }

    companion object {
        fun create(parent: ViewGroup): TypeAViewHolder {
            val binding =
                ListItemTypeABinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TypeAViewHolder(binding)
        }
    }
}