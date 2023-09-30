package ru.potemkin.move4goodapp.domain

import ru.potemkin.move4goodapp.domain.entities.ActivityItem

class GetActivityItemUseCase(private val activityListRepository: ActivityRepository) {
    fun getActivityItem(ActivityItemId: Int): ActivityItem {
        return activityListRepository.getActivityItem(ActivityItemId)
    }
}