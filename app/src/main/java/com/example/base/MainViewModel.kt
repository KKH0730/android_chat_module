package com.example.base

import androidx.constraintlayout.compose.Dimension.Companion.value
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.domain.GetKeytalksUseCase
import com.example.base.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getKeytalksUseCase: GetKeytalksUseCase,
): ViewModel() {

    private val _keytalkFlow = MutableStateFlow<List<String>?>(null)
    val keytalkFlow = _keytalkFlow.asStateFlow()

    private val _message = MutableSharedFlow<String>()
    val message = _message.asSharedFlow()

    fun getKeytalkList(vertical: String = "kyobo_biz") {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getKeytalksUseCase(vertical)
            }


            withContext(Dispatchers.Main) {
                if (result is Result.Success) {
                    _keytalkFlow.value = result.data.map { it.value }
                } else {
                    _message.emit("network error")
                }
            }
        }
    }
}