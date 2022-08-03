package com.example.characters.data

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.characters.databinding.ItemCharacterBinding
import kotlinx.serialization.json.Json.Default.context

class CharacterAdapter(
    private val characterList: MutableList<Charac> = mutableListOf(),
    private val clickListener: (Charac) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context)), clickListener
        )


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    fun update(newCharacterList: List<Charac>) {
        characterList.clear()
        characterList.addAll(newCharacterList)
        notifyDataSetChanged()

    }

    class CharacterViewHolder(
        private val bindingView: ItemCharacterBinding,
        private val clickListener: (Charac) -> Unit
    ) : RecyclerView.ViewHolder(bindingView.root) {

        fun bind(item: Charac) {
            bindingView.tv1.text = item.id.toString()
            bindingView.tv2.text = item.name

            Glide
                .with(itemView.context)
                .load(item.image)
                .into(bindingView.tv4)

            itemView.setOnClickListener {
                clickListener(item)

            }
        }
    }
}

