package com.example.nestedrecyclerswrapissue.mainList

import com.example.nestedrecyclerswrapissue.nestedList.NestedListItem

enum class MainListItemType { NORMAL, CAROUSEL }

sealed class MainListItem(val type: MainListItemType) {
    class NormalItem : MainListItem(MainListItemType.NORMAL)
    data class CarouselItem(val data: List<NestedListItem>) : MainListItem(MainListItemType.CAROUSEL)
}