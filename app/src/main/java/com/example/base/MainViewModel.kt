package com.example.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.domain.GetKeytalksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getKeytalksUseCase: GetKeytalksUseCase,
): ViewModel() {

    private val _keytalkFlow = MutableStateFlow<List<String>?>(null)
    val keytalkFlow = _keytalkFlow.asStateFlow()

    fun getKeytalkList(vertical: String = "kyobo_biz") {
        viewModelScope.launch {
            val keytalkListResponse = withContext(Dispatchers.IO) {
                getKeytalksUseCase.execute(vertical)
            }

            Timber.e("kkh keytalkListResponse : $keytalkListResponse")

            _keytalkFlow.value = keytalkListResponse.map { it.value }
        }
    }
}