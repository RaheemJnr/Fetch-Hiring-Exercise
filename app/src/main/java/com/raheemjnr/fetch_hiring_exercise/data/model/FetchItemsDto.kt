package com.raheemjnr.fetch_hiring_exercise.data.model

import com.squareup.moshi.Json

//data class for items expected to be returned by server..
data class FetchItemsDto(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "listId")
    val listId: Int? = null,
    @Json(name = "name")
    val name: String? = null,
)

// data class of item to be expose to Ui
data class FetchItems(
    val id: Int? = null,
    val listId: Int? = null,
    val name: String? = null,
)


//a helper method to convert dto class to Ui model
fun DToToModel(dto: FetchItemsDto): FetchItems =
    FetchItems(
        id = dto.id,
        listId = dto.listId,
        name = dto.name
    )

fun toDomainList(initial: List<FetchItemsDto>)
        : List<FetchItems> {
    return initial.map { DToToModel(it) }
}