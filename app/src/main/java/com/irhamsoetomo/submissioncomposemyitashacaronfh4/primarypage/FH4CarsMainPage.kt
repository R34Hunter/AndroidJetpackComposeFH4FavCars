package com.irhamsoetomo.submissioncomposemyitashacaronfh4.primarypage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.objectclass.IntegrationData
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.datamodel.ModelListFH4FavCars
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.sealedclass.DataProcessingResult
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.config.ConfigFH4FavCarList
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.viewmodel.VMProvider
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.viewmodel.VMMainPage

@Composable
fun FH4CarMainPage(vmMainPage: VMMainPage = androidx.lifecycle.viewmodel.compose.viewModel(factory = VMProvider(
    IntegrationData.reposCars())
), navigateToDetail: (Long) -> Unit) {
    vmMainPage.processingResultStateFlow.collectAsState(initial = DataProcessingResult.Initializing).value.let {
        when (it) {
            is DataProcessingResult.Initializing -> { vmMainPage.getCarsList() }
            is DataProcessingResult.Accomplished -> { FH4CarListMainPage(modelListFH4FavCars = it.array, intentToCarInformationPage = navigateToDetail) }
            is DataProcessingResult.Failure -> {}
        }
    }
}

@Composable
fun FH4CarListMainPage(modelListFH4FavCars: List<ModelListFH4FavCars>, intentToCarInformationPage: (Long) -> Unit) =
    Box(modifier = Modifier) {
        LazyColumn {
            items(modelListFH4FavCars) {
                ConfigFH4FavCarList(carsName = it.modelFH4FavCars.fh4Cars_name, carsDetailPreview = it.modelFH4FavCars.fh4Cars_detailPreview,
                    carsImage = it.modelFH4FavCars.fh4Cars_image, modifier = Modifier.clickable {
                        intentToCarInformationPage(it.modelFH4FavCars.id)
                    }
                )
            }
        }
    }