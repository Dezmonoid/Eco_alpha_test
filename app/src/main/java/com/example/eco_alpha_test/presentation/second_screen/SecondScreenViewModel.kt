package com.example.eco_alpha_test.presentation.second_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eco_alpha_test.domain.BINRepository
import com.example.eco_alpha_test.presentation.model.BINDetailUI
import com.example.eco_alpha_test.presentation.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SecondScreenViewModel @Inject constructor(
    private val repository: BINRepository
) : ViewModel() {
    private val _liveData = MutableLiveData<List<BINDetailUI>>()
    val liveData: LiveData<List<BINDetailUI>>
        get() = _liveData

    init {
        getDetail()
    }

    private fun getDetail() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val binDetail = repository.getHistoryBINDetail()
                withContext(Dispatchers.Main) {
                    _liveData.value = binDetail.map { it.toUI() }
                    //Log.d("Success", liveData.toString())
                }
            } catch (e: Exception) {
                //Log.d("Error", e.toString())
            }
        }
    }
}