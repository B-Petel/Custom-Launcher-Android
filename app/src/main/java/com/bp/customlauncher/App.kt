package com.bp.customlauncher

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.bp.customlauncher.data.SettingsModel
import com.bp.customlauncher.data.SettingsSerializer
import com.bp.customlauncher.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

val Context.dataStore: DataStore<SettingsModel> by dataStore(
    fileName = "settings.json",
    serializer = SettingsSerializer,
)
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@App)
            // Load modules
            modules(appModule)
        }
    }
}