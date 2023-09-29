package ru.potemkin.move4goodapp.domain

import androidx.lifecycle.LiveData

class GetActivityListUseCase (private val activityListRepository: ActivityRepository) {
    fun getActivityList(): LiveData<List<ActivityItem>> {
        return activityListRepository.getActivityList()
    }
}