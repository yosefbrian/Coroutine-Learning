package com.bankmandiri.poc.coroutineparallel.model

import com.squareup.moshi.Json

data class ActivityResponse(
    @field:Json(name = "ID") val id: Int,
    @field:Json(name = "Title") val title: String,
    @field:Json(name = "DueDate") val dueDate: String,
    @field:Json(name = "Completed") val isCompleted: Boolean
)