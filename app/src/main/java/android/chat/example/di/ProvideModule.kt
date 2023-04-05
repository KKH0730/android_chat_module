package android.chat.example.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ProvideModule {
    @RealTimeDatabase
    @Singleton
    @Provides
    fun provideFirebaseDatabaseRef() : DatabaseReference =
        Firebase.database.getReferenceFromUrl("https://android-chat-module-default-rtdb.firebaseio.com/")
}