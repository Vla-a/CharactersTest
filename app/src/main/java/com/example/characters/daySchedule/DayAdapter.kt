package com.example.schoolorgonizer.lessonSchedule.daySchedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.characters.data.Character
import com.example.characters.databinding.ItemDayBinding

class DayAdapter() : ListAdapter<Character, DayAdapter.DayViewHolder>(DiffUtilItemCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder =
        DayViewHolder(
            ItemDayBinding.inflate(LayoutInflater.from(parent.context))
        )

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DayViewHolder(
        private val bindingView: ItemDayBinding
    ) : RecyclerView.ViewHolder(bindingView.root) {

        fun bind(item: Character) {
            bindingView.tvText.text = item.name
            bindingView.tvDate.text = item.id.toString()
        }
    }
}

class DiffUtilItemCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id && oldItem.name == newItem.name
    }


}