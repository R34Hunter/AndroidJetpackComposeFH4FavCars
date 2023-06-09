package com.irhamsoetomo.submissioncomposemyitashacaronfh4.provider

import com.irhamsoetomo.submissioncomposemyitashacaronfh4.objectclass.ListFH4FavCars
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.datamodel.ModelListFH4FavCars
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ReposCars {
    private val automobile = mutableListOf<ModelListFH4FavCars>()
    init {
        if (automobile.isEmpty()) ListFH4FavCars.forzaHorizonFavCars.forEach { automobile.add(
            ModelListFH4FavCars(it, 0))
        }
    }
    fun getCarsListFlow(): Flow<List<ModelListFH4FavCars>> = flowOf(automobile)
    fun getCarsListId(id: Long): ModelListFH4FavCars = automobile.first { it.modelFH4FavCars.id == id }
    companion object {
        @Volatile
        private var SAMPLE: ReposCars? = null
        fun getCarsSample(): ReposCars = SAMPLE ?: synchronized(this) { ReposCars().apply { SAMPLE = this }
        }
    }
}