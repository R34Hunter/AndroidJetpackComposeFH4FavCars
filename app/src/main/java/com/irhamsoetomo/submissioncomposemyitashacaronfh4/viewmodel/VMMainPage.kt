package com.irhamsoetomo.submissioncomposemyitashacaronfh4.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.provider.ReposCars
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.datamodel.ModelListFH4FavCars
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.sealedclass.DataProcessingResult
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class VMMainPage(private val reposCars: ReposCars) : ViewModel() {
    private val dataProcessingResultMutableStateFlow: MutableStateFlow<DataProcessingResult<List<ModelListFH4FavCars>>> = MutableStateFlow(
        DataProcessingResult.Initializing)
    val processingResultStateFlow: StateFlow<DataProcessingResult<List<ModelListFH4FavCars>>> get() = dataProcessingResultMutableStateFlow
    fun getCarsList() = viewModelScope.launch {
        reposCars.getCarsListFlow().catch {
            dataProcessingResultMutableStateFlow.value = DataProcessingResult.Failure(it.message.toString())
        }.collect { orderRewards ->
            dataProcessingResultMutableStateFlow.value = DataProcessingResult.Accomplished(orderRewards)
        }
    }
}