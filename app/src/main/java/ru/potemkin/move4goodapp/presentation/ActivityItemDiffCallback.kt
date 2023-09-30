package ru.potemkin.move4goodapp.presentation

import androidx.recyclerview.widget.DiffUtil
import ru.potemkin.move4goodapp.domain.entities.ActivityItem

class ActivityItemDiffCallback: DiffUtil.ItemCallback<ActivityItem>() {
    override fun areItemsTheSame(oldItem: ActivityItem, newItem: ActivityItem): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: ActivityItem, newItem: ActivityItem): Boolean {
        return oldItem==newItem
    }
}