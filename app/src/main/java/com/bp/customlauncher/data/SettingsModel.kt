package com.bp.customlauncher.data

import kotlinx.serialization.Serializable

@Serializable
data class SettingsModel(
    val homeAppNumber: Int = 0,
    val homeAppList: List<AppModel> = emptyList(),
    val homeAppPosition: String = "",
    val homeAppFont: String = "",
    val leftSwipeApp: AppModel = AppModel(),
    val rightSwipeApp: AppModel = AppModel(),
    val isBackgroundLight: Boolean = true,
)