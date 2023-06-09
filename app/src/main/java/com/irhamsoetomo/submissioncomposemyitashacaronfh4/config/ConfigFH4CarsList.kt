package com.irhamsoetomo.submissioncomposemyitashacaronfh4.config

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import coil.compose.AsyncImage
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.ui.theme.SubmissionComposeMyItashaCarOnFH4Theme

@Composable
fun ConfigFH4FavCarList(carsName: String, carsDetailPreview: String, carsImage: String, modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.height(15.dp))
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(model = carsImage, contentDescription = "cars_image", contentScale = ContentScale.Crop,
            modifier = Modifier.height(121.dp).width(151.dp).padding(start = 11.dp))
        Column {
            Text(text = carsName, fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.fillMaxHeight().padding(start = 10.dp, end = 10.dp))
            Text(text = carsDetailPreview, fontWeight = FontWeight.Normal, maxLines = 4, fontSize = 15.sp, modifier = Modifier
                    .fillMaxHeight().padding(start = 10.dp, end = 10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConfigFH4FavCarListDemo() = SubmissionComposeMyItashaCarOnFH4Theme {
    ConfigFH4FavCarList(carsName = "Cars Name", carsDetailPreview = "Cars Detail Preview", carsImage = "")
}