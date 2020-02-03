package com.bankmandiri.poc.coroutineparallel.repository

import com.bankmandiri.poc.coroutineparallel.model.ActivityResponse
import com.bankmandiri.poc.coroutineparallel.model.AuthorsResponse
import com.bankmandiri.poc.coroutineparallel.services.DummyService
import javax.inject.Inject

class DataRepository @Inject constructor( val dummyService: DummyService ) {
    suspend fun getActivities(): List<ActivityResponse> {
        return dummyService.getActivities()
    }

    suspend fun getAuthors(): List<AuthorsResponse> =
        dummyService.getAuthors()

    suspend fun getBooks(): List<ActivityResponse> =
        dummyService.getBooks()

    suspend fun getBook(): ActivityResponse =
        dummyService.getBook()

}