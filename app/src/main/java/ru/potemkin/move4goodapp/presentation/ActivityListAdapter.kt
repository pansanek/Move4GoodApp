package ru.potemkin.move4goodapp.presentation

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import ru.potemkin.move4goodapp.R
import ru.potemkin.move4goodapp.domain.ActivityItem
import ru.potemkin.move4goodapp.databinding.ActivityItemBinding

class ActivityListAdapter : ListAdapter<ActivityItem, ActivityItemViewHolder>(
    ActivityItemDiffCallback()
) {

    var onActivityItemLongClickListener: ((ActivityItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityItemViewHolder {
        Log.d("ActivityListAdapter", "onCreateViewHolder called")
        val layout = when (viewType) {
            VIEW_TYPE -> R.layout.activity_item
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent.context),
                layout,
                parent,
                false
            )
        return ActivityItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActivityItemViewHolder, position: Int) {
        Log.d("ActivityListAdapter", "onBindViewHolder called")
        val activityItem = getItem(position)
        val binding = holder.binding
        binding.root.setOnLongClickListener {
            onActivityItemLongClickListener?.invoke(activityItem)
            true
        }
        when (binding) {
            is ActivityItemBinding -> {
                binding.activityItem = activityItem
                binding.circularProgressBar.apply {
                    setProgressWithAnimation(activityItem.count.toFloat(), 1000) // =1s
                    progressMax = activityItem.goal.toFloat()

                    startAngle = 180f
                    progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE
    }

    companion object {
        const val VIEW_TYPE = 0
        const val MAX_POOL_SIZE = 4
    }
}
