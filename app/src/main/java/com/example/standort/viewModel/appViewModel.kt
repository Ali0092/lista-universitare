package com.example.standort.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.standort.model.UniItem
import com.example.standort.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class appViewModel @Inject constructor(private val repo: Repository) : ViewModel() {

    val responseList: MutableLiveData<Response<List<UniItem>>> = MutableLiveData()

    init {
        getResponses()
    }

    fun getResponses() {
        responseList.value = repo.getUniItem()
    }
}