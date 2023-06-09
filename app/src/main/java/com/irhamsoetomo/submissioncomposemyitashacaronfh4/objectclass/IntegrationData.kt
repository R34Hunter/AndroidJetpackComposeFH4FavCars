package com.irhamsoetomo.submissioncomposemyitashacaronfh4.objectclass

import com.irhamsoetomo.submissioncomposemyitashacaronfh4.provider.ReposCars

object IntegrationData { fun reposCars(): ReposCars = ReposCars.getCarsSample() }