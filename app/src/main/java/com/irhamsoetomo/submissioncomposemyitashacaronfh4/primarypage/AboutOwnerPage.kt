package com.irhamsoetomo.submissioncomposemyitashacaronfh4.primarypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.ui.theme.SubmissionComposeMyItashaCarOnFH4Theme

@Composable
fun AboutOwnerPage(modifier: Modifier = Modifier, setOnClickListener:() -> Unit) {
    LazyColumn(modifier = modifier.fillMaxSize().padding(14.dp)) {
        item {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "KALButton",
                modifier = Modifier.padding(14.dp).clickable { setOnClickListener() })
            Image(modifier = modifier.fillMaxSize().height(359.dp).padding(14.dp),
                painter = painterResource(com.irhamsoetomo.submissioncomposemyitashacaronfh4.R.drawable.fotoku_modified),
                contentDescription = "myAboutImage")
            Text(text = "Irham Soetomo H.", fontWeight = FontWeight.Bold,
                fontSize = 31.sp, textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxSize(1.1f)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "irhamsohan86@webmail.umm.ac.id", fontSize = 20.sp,
                textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize(1.1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutOwnerPagePreview() = SubmissionComposeMyItashaCarOnFH4Theme { AboutOwnerPage(setOnClickListener = {}) }