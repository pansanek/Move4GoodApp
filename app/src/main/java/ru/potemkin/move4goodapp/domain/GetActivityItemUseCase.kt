package ru.potemkin.move4goodapp.domain

class GetActivityItemUseCase(private val activityListRepository: ActivityRepository) {
    fun getActivityItem(ActivityItemId: Int): ActivityItem{
        return activityListRepository.getActivityItem(ActivityItemId)
    }
}