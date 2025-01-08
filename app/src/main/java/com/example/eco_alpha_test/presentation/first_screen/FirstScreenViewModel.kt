package com.example.eco_alpha_test.presentation.first_screen

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
class FirstScreenViewModel @Inject constructor(
    private val repository: BINRepository
) : ViewModel() {
    private val _liveData = MutableLiveData<BINDetailUI>()
    val liveData: LiveData<BINDetailUI>
        get() = _liveData

    fun getDetail(number: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val binDetail = repository.getBINDetail(number)
                withContext(Dispatchers.Main) {
                    _liveData.value = binDetail.toUI()
                    Log.d("Success", liveData.toString())
                }
            } catch (e: Exception) {
                Log.d("Error", e.toString())
            }
        }
    }
}