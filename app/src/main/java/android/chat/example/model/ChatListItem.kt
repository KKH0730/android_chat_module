package android.chat.example.model

data class ChatListItem(
    var unCheckedMessageCount: Int,
    var chatMessages: List<ChatMessage>
)