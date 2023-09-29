package ru.potemkin.move4goodapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.potemkin.move4goodapp.domain.ActivityItem
import ru.potemkin.move4goodapp.domain.ActivityRepository

object ActivityRepositoryImpl: ActivityRepository {

    private val activityListLiveData = MutableLiveData<List<ActivityItem>>()
    private val activityList= sortedSetOf<ActivityItem>({ p0, p1 -> p0.id.compareTo(p1.id) })

    private var autoIncrementId =0

    init{
        val item = ActivityItem("Шаги",5678,10000,1)
        val item2 = ActivityItem("Калории",499,500,2)
        val item3 = ActivityItem("Бег",0,2000,3)
        val item4 = ActivityItem("Ролики",100,1000,4)
        addActivityItem(item)
        addActivityItem(item2)
        addActivityItem(item3)
        addActivityItem(item4)
    }

    override fun addActivityItem(activityItem: ActivityItem) {
        if(activityItem.id == ActivityItem.UNDEFINED_ID) {
            activityItem.id = autoIncrementId++
        }
        activityList.add(activityItem)
        updateList()
    }

    override fun deleteActivityItem(activityItem: ActivityItem) {
        activityList.remove(activityItem)
        updateList()
    }

    override fun editActivityItem(activityItem: ActivityItem) {
        val oldElement = getActivityItem(activityItem.id)
        activityList.remove(oldElement)
        addActivityItem(activityItem)
    }

    override fun getActivityItem(ActivityItemId: Int): ActivityItem {
        return activityList.find {
            it.id == ActivityItemId
        } ?: throw java.lang.RuntimeException("Element with id $ActivityItemId not found")
    }

    override fun getActivityList(): LiveData<List<ActivityItem>> {
        return activityListLiveData
    }
    private fun updateList(){
        activityListLiveData.value = activityList.toList()
    }

}