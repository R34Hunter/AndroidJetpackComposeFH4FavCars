package com.irhamsoetomo.submissioncomposemyitashacaronfh4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.config.ConfigNavHostController
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.ui.theme.SubmissionComposeMyItashaCarOnFH4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SubmissionComposeMyItashaCarOnFH4Theme {
                Surface( modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.primary) {
                    ConfigNavHostController()
                }
            }
        }
    }
}