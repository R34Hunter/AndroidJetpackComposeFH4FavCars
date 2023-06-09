package com.irhamsoetomo.submissioncomposemyitashacaronfh4.sealedclass

sealed class Pathing(val path: String) {
    object CarsMainPage: Pathing("mainPage")
    object AboutOwnerPage: Pathing("aboutOwner")
    object CarsInformationPage: Pathing("mainPage/{id}") { fun getCarsListIdentifier(id: Long) = "mainPage/$id" }
}