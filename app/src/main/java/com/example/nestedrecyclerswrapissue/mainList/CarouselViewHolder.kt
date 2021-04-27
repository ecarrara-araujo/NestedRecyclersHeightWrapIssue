package com.example.nestedrecyclerswrapissue.mainList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerswrapissue.WrappingLinearLayoutManager
import com.example.nestedrecyclerswrapissue.databinding.ListItemCarouselBinding
import com.example.nestedrecyclerswrapissue.nestedList.NestedListItemsAdapter

class CarouselViewHolder(private val binding: ListItemCarouselBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MainListItem) {
        (item as? MainListItem.CarouselItem)?.let {
            binding.list.apply {
                layoutManager = if (item.useWrappingLayoutManager) {
                    WrappingLinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                } else {
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                }

                adapter = NestedListItemsAdapter().apply { submitList(item.data) }
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): CarouselViewHolder {
            val binding =
                ListItemCarouselBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return CarouselViewHolder(binding)
        }
    }
}