package com.example.nestedrecyclerswrapissue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecyclerswrapissue.databinding.ActivityMainBinding
import com.example.nestedrecyclerswrapissue.mainList.MainListItem.CarouselItem
import com.example.nestedrecyclerswrapissue.mainList.MainListItem.NormalItem
import com.example.nestedrecyclerswrapissue.nestedList.NestedListItemType.TYPE_A
import com.example.nestedrecyclerswrapissue.nestedList.NestedListItemType.TYPE_B
import com.example.nestedrecyclerswrapissue.mainList.MainlistItemsAdapter
import com.example.nestedrecyclerswrapissue.nestedList.NestedListItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val carouselData = listOf(
        NestedListItem(type = TYPE_B),
        NestedListItem(type = TYPE_B),
        NestedListItem(type = TYPE_B),
        NestedListItem(type = TYPE_B),
        NestedListItem(type = TYPE_B),
        NestedListItem(type = TYPE_B),
        NestedListItem(type = TYPE_B),
        NestedListItem(type = TYPE_A),
    )

    private val mainData = listOf(
            NormalItem(),
            CarouselItem(data = carouselData),
            NormalItem(),
            NormalItem(),
            NormalItem(),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpList()
    }

    private fun setUpList() {
        binding.list.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = MainlistItemsAdapter().apply { submitList(mainData) }

        }
    }
}