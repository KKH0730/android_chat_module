package android.chat.example.data

import android.chat.example.di.RealTimeDatabase
import android.chat.example.model.ChatListItem
import android.chat.example.model.ChatMessage
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.google.gson.Gson
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class ChatListImpl @Inject constructor(
    @RealTimeDatabase private val  db: DatabaseReference
): ChatListRepository {

    override suspend fun reqChatList(
        myUid: String,
        otherUid: String
    ): Flow<Pair<String, ChatListItem>> {
        return callbackFlow {
            val childEventListener = object: ChildEventListener {
                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
                override fun onChildRemoved(snapshot: DataSnapshot) {}
                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
                override fun onCancelled(error: DatabaseError) {}
                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                    kotlin.runCatching {
                        var unCheckedMessageCount = 0

                        snapshot.children.toMutableList()
                            .takeIf { dataSnapshotList ->
                                dataSnapshotList.isNotEmpty()
                            }
                            ?.let { dataSnapshotList ->
                                if (dataSnapshotList.last().key == "unCheckedMessageCount") {
                                    unCheckedMessageCount = (dataSnapshotList.last().value as Long).toInt()
                                    dataSnapshotList.remove(dataSnapshotList.last())
                                }
                                dataSnapshotList
                            }
                            ?.let { dataSnapshotList ->
                                val chatMessages = arrayListOf<ChatMessage>()
                                dataSnapshotList.forEach {
                                    val chatMessage = Gson().fromJson(it.value.toString(), ChatMessage::class.java)
                                    chatMessages.add(chatMessage)
                                }
                                val chatListItem = ChatListItem(
                                    unCheckedMessageCount = unCheckedMessageCount,
                                    chatMessages = chatMessages
                                )
                                snapshot.key!! to chatListItem
                            }
                    }.onSuccess { result: Pair<String, ChatListItem>? ->
                        result?.let { trySend(it) }
                    }
                }
            }
            val databaseReference = db.child("chat_rooms")
                .child(myUid)
                .orderByChild("timestamp")
                .endBefore(Calendar.getInstance().timeInMillis.toString())


            databaseReference.addChildEventListener(childEventListener)
            awaitClose { databaseReference.removeEventListener(childEventListener) }
        }
    }
}