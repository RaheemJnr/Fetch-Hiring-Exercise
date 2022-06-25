package com.raheemjnr.fetch_hiring_exercise.data.model

import com.squareup.moshi.Json

//data class for items expected to be returned by server..
data class FetchItems(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "listId")
    val listId: Int? = null,
    @Json(name = "name")
    val name: String? = null,
)