package com.irhamsoetomo.submissioncomposemyitashacaronfh4.sealedclass

sealed class DataProcessingResult<out T: Any?> {
    object Initializing: DataProcessingResult<Nothing>()
    data class Accomplished<out T: Any>(val array: T) : DataProcessingResult<T>()
    data class Failure(val fail: String) : DataProcessingResult<Nothing>()
}