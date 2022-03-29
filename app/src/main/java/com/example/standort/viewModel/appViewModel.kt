package com.example.standort.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.standort.model.UniItem
import com.example.standort.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class appViewModel @Inject constructor(private val repo: Repository) : ViewModel() {

    val responseList: MutableLiveData<Response<List<UniItem>>> = MutableLiveData()

    fun getResponses(name:String) {
        viewModelScope.launch {
            responseList.value = repo.getUniItem(name)
        }
    }
}