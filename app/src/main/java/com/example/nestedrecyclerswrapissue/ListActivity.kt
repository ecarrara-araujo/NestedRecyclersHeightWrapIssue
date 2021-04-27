package com.example.nestedrecyclerswrapissue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecyclerswrapissue.databinding.ActivityListBinding
import com.example.nestedrecyclerswrapissue.mainList.MainListItem
import com.example.nestedrecyclerswrapissue.mainList.MainlistItemsAdapter
import com.example.nestedrecyclerswrapissue.nestedList.NestedListItem
import com.example.nestedrecyclerswrapissue.nestedList.NestedListItemType

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private var usesCustomLayoutManager = false

    private val carouselData = listOf(
        NestedListItem(type = NestedListItemType.TYPE_B),
        NestedListItem(type = NestedListItemType.TYPE_B),
        NestedListItem(type = NestedListItemType.TYPE_B),
        NestedListItem(type = NestedListItemType.TYPE_B),
        NestedListItem(type = NestedListItemType.TYPE_B),
        NestedListItem(type = NestedListItemType.TYPE_B),
        NestedListItem(type = NestedListItemType.TYPE_B),
        NestedListItem(type = NestedListItemType.TYPE_A),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usesCustomLayoutManager =
            intent.getBooleanExtra(PARAM_USES_CUSTOM_LAYOUT_MANAGER_FLAG, false)

        setUpList()
    }

    private fun setUpList() {
        binding.list.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = MainlistItemsAdapter().apply { submitList(createMainListData()) }
        }
    }

    private fun createMainListData() = listOf(
        MainListItem.NormalItem(),
        MainListItem.CarouselItem(carouselData, usesCustomLayoutManager),
        MainListItem.NormalItem(),
        MainListItem.NormalItem(),
        MainListItem.NormalItem(),
    )

    companion object {
        const val PARAM_USES_CUSTOM_LAYOUT_MANAGER_FLAG = "PARAM_USES_CUSTOM_LAYOUT_MANAGER_FLAG"
    }
}