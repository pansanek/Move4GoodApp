package ru.potemkin.move4goodapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.potemkin.move4goodapp.data.ActivityRepositoryImpl
import ru.potemkin.move4goodapp.domain.GetActivityListUseCase

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = ActivityRepositoryImpl

    private val getActivityListUseCase = GetActivityListUseCase(repository)

    val activityList = getActivityListUseCase.getActivityList()



}
