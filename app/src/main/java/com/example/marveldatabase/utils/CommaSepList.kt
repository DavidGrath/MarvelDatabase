package com.example.marveldatabase.utils

class CommaSepList<T>(val list: List<T>) {
    override fun toString(): String {
        return list.joinToString { "," }
    }
}