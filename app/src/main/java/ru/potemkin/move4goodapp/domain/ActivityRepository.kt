package ru.potemkin.move4goodapp.domain

import androidx.lifecycle.LiveData
import ru.potemkin.move4goodapp.domain.entities.ActivityItem

interface ActivityRepository {
     fun addActivityItem(activityItem: ActivityItem)

     fun deleteActivityItem(activityItem: ActivityItem)

     fun editActivityItem(activityItem: ActivityItem)

     fun getActivityItem(ActivityItemId: Int): ActivityItem

    fun getActivityList(): LiveData<List<ActivityItem>>
}