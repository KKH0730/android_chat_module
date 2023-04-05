package android.chat.example.model

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class ChatMessage(
    val message: String,
    val myName: String,
    val myUid: String,
    val otherName: String,
    val otherUid: String,
    val timestamp: Long
) {
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "message" to message,
            "myName" to myName,
            "myUid" to myUid,
            "otherName" to otherName,
            "otherUid" to otherUid,
            "timestamp" to timestamp
        )
    }
}