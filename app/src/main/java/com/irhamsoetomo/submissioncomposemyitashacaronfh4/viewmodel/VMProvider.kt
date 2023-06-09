package com.irhamsoetomo.submissioncomposemyitashacaronfh4.viewmodel

import androidx.lifecycle.*
import com.irhamsoetomo.submissioncomposemyitashacaronfh4.provider.ReposCars

class VMProvider(private val reposCars: ReposCars) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(tClass: Class<T>): T {
        if (tClass.isAssignableFrom(VMMainPage::class.java)) { return VMMainPage(reposCars) as T }
        else if (tClass.isAssignableFrom(VMFH4CarsInformationPage::class.java)) { return VMFH4CarsInformationPage(reposCars) as T }
        throw IllegalArgumentException("ViewModel class not identified: " + tClass.name)
    }
}