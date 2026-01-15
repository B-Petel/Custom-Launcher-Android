package com.bp.customlauncher

import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.bp.customlauncher.data.AppModel
import com.bp.customlauncher.data.SettingsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

class MainViewModel(
    private val application: Application
): AndroidViewModel(application) {
    val intent = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER)
    val flags = PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_ALL.toLong())
    val activities: List<ResolveInfo> = application.packageManager.queryIntentActivities(intent, flags)

    fun getAllApps(): List<AppModel> {
        return activities.map { resolveInfo ->
            AppModel(
                name = resolveInfo.loadLabel(application.packageManager).toString(),
                packageName = resolveInfo.activityInfo.packageName
            )
        }
    }

    private val _homeState = MutableStateFlow<List<AppModel>>(emptyList())
    val homeState: StateFlow<List<AppModel>> = _homeState.asStateFlow()

    fun setHomeApps() = application.dataStore.data.map { settings ->
        _homeState.value = settings.homeAppList
    }

    private val _settingsState = MutableStateFlow(SettingsModel())
    val settingsState: StateFlow<SettingsModel> = _settingsState.asStateFlow()

    fun setSettings() = application.dataStore.data.map { settings ->
        _settingsState.value = settings
    }
}