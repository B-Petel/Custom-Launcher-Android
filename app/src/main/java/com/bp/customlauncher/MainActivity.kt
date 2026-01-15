package com.bp.customlauncher

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import com.bp.customlauncher.presentation.HomeScreen
import com.bp.customlauncher.ui.theme.CustomLauncherTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val context = this

        setContent {
            CustomLauncherTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier
                        .padding(innerPadding)
                        .pointerInput(Unit) {
                            detectHorizontalDragGestures { x, y ->
                                if (y > 0) {
                                    Toast.makeText(context, "left", Toast.LENGTH_LONG)
                                } else {
                                    Toast.makeText(context, "right", Toast.LENGTH_LONG)
                                }
                            }
                            detectVerticalDragGestures { x, y ->
                                if (y > 0) {
                                    Toast.makeText(context, "down", Toast.LENGTH_LONG)
                                } else {
                                    Toast.makeText(context, "up", Toast.LENGTH_LONG)
                                }
                            }
                        }
                    ) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}
