package com.example.nestedrecyclerswrapissue.mainList

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MainlistItemsAdapter : ListAdapter<MainListItem, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            MainListItemType.NORMAL.ordinal -> NormalViewHolder.create(parent)
            MainListItemType.CAROUSEL.ordinal -> CarouselViewHolder.create(parent)
            else -> throw IllegalArgumentException("Error ...")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position)?.type?.ordinal ?: -1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let {
            when (holder) {
                is NormalViewHolder -> holder.bind()
                is CarouselViewHolder -> holder.bind(it)
                else -> throw IllegalArgumentException("Error ...")
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MainListItem>() {
            override fun areItemsTheSame(
                oldItem: MainListItem,
                newItem: MainListItem
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: MainListItem,
                newItem: MainListItem
            ): Boolean = oldItem == newItem
        }
    }
}