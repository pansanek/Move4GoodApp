package ru.potemkin.move4goodapp.domain

import androidx.lifecycle.LiveData

interface ActivityRepository {
     fun addActivityItem(activityItem: ActivityItem)

     fun deleteActivityItem(activityItem: ActivityItem)

     fun editActivityItem(activityItem: ActivityItem)

     fun getActivityItem(ActivityItemId: Int): ActivityItem

    fun getActivityList(): LiveData<List<ActivityItem>>
}