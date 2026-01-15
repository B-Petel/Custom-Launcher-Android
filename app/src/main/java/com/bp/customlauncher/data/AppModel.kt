package com.bp.customlauncher.data

import kotlinx.serialization.Serializable

@Serializable
data class AppModel(
    val name: String = "",
    val packageName: String = "",
    val isHide: Boolean = false
)