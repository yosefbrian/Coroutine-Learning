package com.bankmandiri.poc.coroutineparallel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bankmandiri.poc.coroutineparallel.model.ActivityResponse
import com.bankmandiri.poc.coroutineparallel.model.AuthorsResponse
import com.bankmandiri.poc.coroutineparallel.repository.DataRepository
import kotlinx.coroutines.*
import retrofit2.HttpException
import javax.inject.Inject

class MainViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {

    val activityData: MutableLiveData<List<ActivityResponse>> = MutableLiveData()
    val bookData: MutableLiveData<List<ActivityResponse>> = MutableLiveData()
    val authorData: MutableLiveData<List<AuthorsResponse>> = MutableLiveData()
    val book: MutableLiveData<ActivityResponse> = MutableLiveData()


    fun getActivities() =
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    activityData.postValue(dataRepository.getActivities())
                }
                catch (e: HttpException){
                    e.printStackTrace()
                }

            }
        }




    fun getAuthors() =
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                authorData.postValue(dataRepository.getAuthors())
            }
        }


    fun getBooks() =
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                bookData.postValue(dataRepository.getBooks())
            }
        }


    fun getBook() =
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                book.postValue(dataRepository.getBook())
            }
        }


}
