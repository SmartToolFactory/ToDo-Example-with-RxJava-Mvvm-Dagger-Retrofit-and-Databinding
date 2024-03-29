package com.smarttoolfactory.todoplus.tasks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smarttoolfactory.todoplus.data.model.Task
import com.smarttoolfactory.todoplus.databinding.TaskItemBinding
import com.smarttoolfactory.todoplus.tasks.TaskListViewModel
import com.smarttoolfactory.todoplus.tasks.adapter.TasksAdapter.CustomViewHolder

/**
 * Adapter for the task list. Has a reference to the [TaskListViewModel] to send actions back to it.
 *
 * Layout of the rows is determined by type of the binding class. For this adapter it's [TaskItemBinding]
 * which is retrieved from task_item.xml
 */
class TasksAdapter(private val viewModel: TaskListViewModel) :
        ListAdapter<Task, CustomViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        println("🎃🎃 TaskAdapter onCreateViewHolder() viewType: $viewType")
        return CustomViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val item = getItem(position)
        println("🔥🔥 TaskAdapter onBindViewHolder() position: $position, holder: $holder")
        holder.bind(viewModel, item)
    }

    override fun onViewRecycled(holder: CustomViewHolder) {
        super.onViewRecycled(holder)
        println("🥶🥶 TaskAdapter onViewRecycled() holder $holder")
    }


    class CustomViewHolder private constructor(private val binding: TaskItemBinding) :
            RecyclerView.ViewHolder(binding.root) {


        fun bind(viewModel: TaskListViewModel, item: Task) {
            binding.viewmodel = viewModel
            binding.task = item
            binding.executePendingBindings()
        }


        companion object {
            fun from(parent: ViewGroup): CustomViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)

                return CustomViewHolder(binding)
            }
        }
    }
}

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minimum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */
class TaskDiffCallback : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }
}
