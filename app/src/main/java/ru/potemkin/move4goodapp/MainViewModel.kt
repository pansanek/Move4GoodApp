package ru.potemkin.move4goodapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import ru.potemkin.move4goodapp.domain.ActivityItem
import ru.potemkin.move4goodapp.data.ActivityRepositoryImpl
import ru.potemkin.move4goodapp.domain.GetActivityListUseCase

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = ActivityRepositoryImpl

    private val getActivityListUseCase = GetActivityListUseCase(repository)

    val activityList = getActivityListUseCase.getActivityList()



}
