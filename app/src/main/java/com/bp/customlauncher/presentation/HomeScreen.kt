package com.bp.customlauncher.presentation

import android.widget.Toast
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import com.bp.customlauncher.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    mainViewModel: MainViewModel = koinViewModel()
) {
    val homeAppsState = mainViewModel.homeState.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        homeAppsState.value.forEach {
            item {
                Text(it.name)
            }
        }
    }
}
