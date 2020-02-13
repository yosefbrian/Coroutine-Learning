package com.bankmandiri.poc.coroutineparallel.services

import com.bankmandiri.poc.coroutineparallel.model.ActivityResponse
import com.bankmandiri.poc.coroutineparallel.model.AuthorsResponse
import com.bankmandiri.poc.coroutineparallel.utils.Result
import retrofit2.http.DELETE
import retrofit2.http.GET

interface DummyService {

    @GET("api/Activities")
    suspend fun getActivities(): List<ActivityResponse>

    @GET("api/Authors")
    suspend fun getAuthors(): List<AuthorsResponse>

    @GET("api/Books")
    suspend fun getBooks(): List<ActivityResponse>

    @GET("api/Activities/1")
    suspend fun getBook(): ActivityResponse
}