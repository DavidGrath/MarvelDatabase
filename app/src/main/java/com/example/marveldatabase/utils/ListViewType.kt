package com.example.marveldatabase.utils

sealed class ListViewType<HeaderType, ItemType>() {
    abstract fun getType(): Int
    class Header<HeaderType, ItemType>(val data: HeaderType) :
        ListViewType<HeaderType, ItemType>() {
        override fun getType(): Int {
            return Constants.LISTVIEW_TYPE_HEADER
        }
    }

    class Item<HeaderType, ItemType>(val data: ItemType) : ListViewType<HeaderType, ItemType>() {
        override fun getType(): Int {
            return Constants.LISTVIEW_TYPE_ITEM
        }
    }
}