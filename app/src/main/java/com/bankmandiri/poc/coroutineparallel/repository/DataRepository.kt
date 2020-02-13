package com.bankmandiri.poc.coroutineparallel.repository

import com.bankmandiri.poc.coroutineparallel.model.ActivityResponse
import com.bankmandiri.poc.coroutineparallel.model.AuthorsResponse
import com.bankmandiri.poc.coroutineparallel.services.DummyService
import com.bankmandiri.poc.coroutineparallel.utils.Result
import javax.inject.Inject

class DataRepository @Inject constructor(private val dummyService: DummyService ) {

    suspend fun getActivities(): Result<List<ActivityResponse>> =
        try {
            Result.Success(dummyService.getActivities())
        } catch (e: Exception){
            Result.Failure(e)
        }


    suspend fun getAuthors(): Result<List<AuthorsResponse>> =
        try {
            Result.Success(dummyService.getAuthors())
        }catch(e: Exception) {
            Result.Failure(e)
        }


    suspend fun getBooks(): Result<List<ActivityResponse>> =
        try {
            Result.Success(dummyService.getBooks())
        }
        catch (e: Exception){
            Result.Failure(e)
        }


}