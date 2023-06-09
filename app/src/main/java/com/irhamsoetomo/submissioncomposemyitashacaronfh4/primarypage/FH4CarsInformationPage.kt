package com.irhamsoetomo.submissioncomposemyitashacaronfh4.primarypage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import coil.compose.AsyncImage
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.objectclass.IntegrationData
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.sealedclass.DataProcessingResult
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.viewmodel.VMProvider
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.viewmodel.VMFH4CarsInformationPage
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.ui.theme.SubmissionComposeMyItashaCarOnFH4Theme

@Composable
fun FH4CarsInformation(id: Long, vmfH4CarsInformationPage: VMFH4CarsInformationPage = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = VMProvider(IntegrationData.reposCars())
), navigateBack: () -> Unit) {
    vmfH4CarsInformationPage.processingResultStateFlow.collectAsState(initial = DataProcessingResult.Initializing).value.let {
        when(it) {
            is DataProcessingResult.Initializing -> { vmfH4CarsInformationPage.getIdentifierList(id) }
            is DataProcessingResult.Accomplished -> {
                val data = it.array
                FH4CarInformation(cars_name = data.modelFH4FavCars.fh4Cars_name, cars_detailPreview = data.modelFH4FavCars.fh4Cars_detailPreview,
                    cars_yearProduction = data.modelFH4FavCars.fh4Cars_yearProduction, cars_image = data.modelFH4FavCars.fh4Cars_image,
                    setOnClickListener = navigateBack)
            }
            is DataProcessingResult.Failure -> {}
        }
    }
}

@Composable
fun FH4CarInformation(cars_name: String, cars_detailPreview: String, cars_yearProduction: String, cars_image: String, setOnClickListener: () -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize().padding(16.dp)) {
        item {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Back", modifier = Modifier.padding(16.dp).clickable { setOnClickListener() })
            AsyncImage(model = cars_image, contentDescription = "cars_image")
            Spacer(modifier = Modifier.height(9.dp))
            Text(text = cars_name, fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = cars_detailPreview, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Others Insight", fontWeight = FontWeight.Bold, fontSize = 21.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "Car's Production Year : $cars_yearProduction")
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_3A_XL)
@Composable
fun FH4CarInformationPreview() = SubmissionComposeMyItashaCarOnFH4Theme{
        FH4CarInformation(cars_name = "cars_name", cars_detailPreview = "cars_detailPreview", cars_yearProduction = "cars_yearProduction",
            cars_image = "cars_image", setOnClickListener = {})
}