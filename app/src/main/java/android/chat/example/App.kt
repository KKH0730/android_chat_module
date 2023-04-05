package android.chat.example

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    companion object {
        private lateinit var instance: android.chat.example.App
        fun getInstance(): android.chat.example.App = android.chat.example.App.Companion.instance
    }


    override fun onCreate() {
        super.onCreate()
        android.chat.example.App.Companion.instance = this
        Timber.plant(Timber.DebugTree())
    }

}