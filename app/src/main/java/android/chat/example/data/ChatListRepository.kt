package android.chat.example.data

import android.chat.example.model.ChatListItem
import kotlinx.coroutines.flow.Flow

interface ChatListRepository {

    suspend fun reqChatList(myUid: String, otherUid: String): Flow<Pair<String, ChatListItem>>
}