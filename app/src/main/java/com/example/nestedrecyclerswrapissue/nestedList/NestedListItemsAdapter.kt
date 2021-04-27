package com.example.nestedrecyclerswrapissue.nestedList

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class NestedListItemsAdapter : ListAdapter<NestedListItem, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            NestedListItemType.TYPE_A.ordinal -> TypeAViewHolder.create(parent)
            NestedListItemType.TYPE_B.ordinal -> TypeBViewHolder.create(parent)
            else -> throw IllegalArgumentException("Error ...")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.type?.ordinal ?: -1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let {
            when (holder) {
                is TypeAViewHolder -> holder.bind()
                is TypeBViewHolder -> holder.bind()
                else -> throw IllegalArgumentException("Error ...")
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<NestedListItem>() {
            override fun areItemsTheSame(
                oldItem: NestedListItem,
                newItem: NestedListItem
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: NestedListItem,
                newItem: NestedListItem
            ): Boolean = oldItem == newItem
        }
    } 
}