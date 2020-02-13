package com.bankmandiri.poc.coroutineparallel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bankmandiri.poc.coroutineparallel.model.ActivityResponse
import com.bankmandiri.poc.coroutineparallel.model.AuthorsResponse
import com.bankmandiri.poc.coroutineparallel.repository.DataRepository
import com.bankmandiri.poc.coroutineparallel.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {

    val activityData: MutableLiveData<List<ActivityResponse>> = MutableLiveData()
    val bookData: MutableLiveData<List<ActivityResponse>> = MutableLiveData()
    val authorData: MutableLiveData<List<AuthorsResponse>> = MutableLiveData()


    fun getActivitiesAsync() =
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                when (val result = dataRepository.getActivities()) {
                    is Result.Success -> activityData.postValue(result.data)
                    is Result.Failure -> result.error?.printStackTrace()
                }
            }
        }


    fun getAuthorsAsync() =
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                when (val result = dataRepository.getAuthors()) {
                    is Result.Success -> authorData.postValue(result.data)
                    is Result.Failure -> result.error?.printStackTrace()
                }
            }
        }


    fun getBooksAsync() =
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                when (val result = dataRepository.getBooks()) {
                    is Result.Success -> bookData.postValue(result.data)
                    is Result.Failure -> result.error?.printStackTrace()
                }
            }
        }
}
