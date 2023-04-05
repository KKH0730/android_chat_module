package android.chat.example.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object ServiceModule {
//    @Singleton
//    @Provides
//    fun provideKeytalkService(retrofit: Retrofit): KeytalkService = retrofit.create()
}