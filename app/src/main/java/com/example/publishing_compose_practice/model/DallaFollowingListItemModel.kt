package com.example.publishing_compose_practice.model

data class DallaFollowingListItemModel(
    val bjImage: Int,
    val count: Int = 0,
    val name: String,
    val isOnlined: Boolean,
    val isOvered: Boolean = false
)
