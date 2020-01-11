package com.siyu.doordashlite.entity

data class Menu(
    val id: Int,
    val is_catering: Boolean,
    val name: String,
    val popular_items: List<PopularItem>,
    val subtitle: String
)