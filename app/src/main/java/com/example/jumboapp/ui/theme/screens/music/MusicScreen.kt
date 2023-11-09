package com.example.jumboapp.ui.theme.screens.music

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.jumboapp.ui.theme.JumboAppTheme

@Composable
fun MusicScreen(navController: NavController, permissions: Array<String>) {
    // Implement your music options and logic here
    val context = LocalContext.current
    var isPlaying by remember { mutableStateOf(false) }
    var currentSong by remember { mutableStateOf("No song play next song") }

    val requestCode = 123 // An arbitrary request code
    DisposableEffect(Unit) {
        ActivityCompat.requestPermissions(context as Activity, permissions, requestCode)
        onDispose { /* Cleanup if needed */ }
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = currentSong,
            color = Color.Blue
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Play music logic here
                isPlaying = true
                currentSong = "Now Playing: Song Name"
            }
        ) {
            Text(text = "Play")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                // Pause music logic here
                isPlaying = false
            }
        ) {
            Text(text = "Pause")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                // Stop music logic here
                isPlaying = false
                currentSong = "No Song Playing"
            }
        ) {
            Text(text = "Stop")
        }
    }
}

@Composable
fun MusicScreen(navController: NavHostController) {
    JumboAppTheme {
        MusicScreen(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMusicScreen() {
    MusicScreen(navController)
}




