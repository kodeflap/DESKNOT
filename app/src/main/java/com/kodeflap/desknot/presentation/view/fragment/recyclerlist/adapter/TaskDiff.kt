package com.kodeflap.desknot.presentation.view.fragment.recyclerlist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.kodeflap.desknot.data.TaskInfo

class TaskDiff(
	private val oldList: List<TaskInfo>,
	private val newList: List<TaskInfo>
): DiffUtil.Callback() {
	override fun getOldListSize() = oldList.size

	override fun getNewListSize() = newList.size

	override fun areItemsTheSame(
		oldItemPosition: Int,
		newItemPosition: Int
	) = oldList[oldItemPosition] === newList[newItemPosition]

	override fun areContentsTheSame(
		oldItemPosition: Int,
		newItemPosition: Int
	) = oldList[oldItemPosition] == newList[newItemPosition]
}