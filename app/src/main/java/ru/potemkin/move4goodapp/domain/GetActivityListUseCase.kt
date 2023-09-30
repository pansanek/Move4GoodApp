package ru.potemkin.move4goodapp.domain

import androidx.lifecycle.LiveData
import ru.potemkin.move4goodapp.domain.entities.ActivityItem

class GetActivityListUseCase (private val activityListRepository: ActivityRepository) {
    fun getActivityList(): LiveData<List<ActivityItem>> {
        return activityListRepository.getActivityList()
    }
}