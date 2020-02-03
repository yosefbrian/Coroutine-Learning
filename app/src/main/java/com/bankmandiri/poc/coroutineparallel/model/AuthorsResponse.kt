package com.bankmandiri.poc.coroutineparallel.model

import com.squareup.moshi.Json

data class AuthorsResponse(
    @field:Json(name = "ID") val id: Int,
    @field:Json(name = "IDBook") val idBook: Int,
    @field:Json(name = "FirstName") val firstName: String
)