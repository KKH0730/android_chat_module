package android.chat.example.di

import javax.inject.Qualifier

// Dispatcher Qualifier
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ApplicationScope

// Gson Qualifier
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class GeneralGson

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class NetworkGson

// Others Qualifier
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class RealTimeDatabase
