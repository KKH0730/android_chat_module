package android.chat.example.di

import android.chat.example.data.ChatListImpl
import android.chat.example.data.ChatListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindChatListRepository(chatListImpl: ChatListImpl): ChatListRepository
}