package ru.potemkin.move4goodapp.presentation

import androidx.recyclerview.widget.DiffUtil
import ru.potemkin.move4goodapp.domain.ActivityItem

class ActivityListDiffCallback (
    private val oldList:List<ActivityItem>,
    private val newList:List<ActivityItem>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem==newItem
    }

}
