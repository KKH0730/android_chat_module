package android.chat.example

import android.chat.example.di.IoDispatcher
import android.chat.example.domain.ChatListUseCase
import android.chat.example.model.ChatListItem
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ChatListViewModel @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val chatListUseCase: ChatListUseCase
) : ViewModel() {

    private val _chatListStateFlow = MutableSharedFlow<Pair<String, ChatListItem>>()
    val chatListStateFlow get() = _chatListStateFlow.asSharedFlow()

    fun reqChatList(myUid: String, otherUid: String) {
        viewModelScope.launch {
            chatListUseCase.reqChatList(myUid = myUid, otherUid = otherUid)
                .flowOn(ioDispatcher)
                .collect {
                    _chatListStateFlow.emit(it)
                    Timber.e("kkhdev first : ${it.first}, second : ${it.second}")
                }
        }
    }
}