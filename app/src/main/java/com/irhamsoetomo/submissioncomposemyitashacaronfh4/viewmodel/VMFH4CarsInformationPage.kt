package com.irhamsoetomo.submissioncomposemyitashacaronfh4.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.provider.ReposCars
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.datamodel.ModelListFH4FavCars
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.sealedclass.DataProcessingResult
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class VMFH4CarsInformationPage(private val reposCars: ReposCars) : ViewModel() {
    private val dataProcessingResultMutableStateFlow: MutableStateFlow<DataProcessingResult<ModelListFH4FavCars>> = MutableStateFlow(
        DataProcessingResult.Initializing)
    val processingResultStateFlow: StateFlow<DataProcessingResult<ModelListFH4FavCars>> get() = dataProcessingResultMutableStateFlow
    fun getIdentifierList(id: Long) = viewModelScope.launch {
        dataProcessingResultMutableStateFlow.value = DataProcessingResult.Initializing
        dataProcessingResultMutableStateFlow.value = DataProcessingResult.Accomplished(reposCars.getCarsListId(id))
    }
}