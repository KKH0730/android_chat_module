package android.chat.example.domain

import android.chat.example.data.ChatListRepository
import android.chat.example.model.ChatListItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChatListUseCase @Inject constructor(
    private val chatListRepository: ChatListRepository
) {

    suspend fun reqChatList(myUid: String, otherUid: String) : Flow<Pair<String, ChatListItem>> {
        return chatListRepository.reqChatList(
            myUid = myUid, otherUid = otherUid
        )
    }
}