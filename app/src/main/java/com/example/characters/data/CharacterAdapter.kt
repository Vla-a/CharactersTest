package com.example.characters.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.characters.databinding.ItemCharacterBinding

class CharacterAdapter(
    private val characterList: MutableList<Character> = mutableListOf(),
    private val clickListener: (Character) -> Unit
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

    fun update(newCharacterList: List<Character>) {
        characterList.clear()
        characterList.addAll(newCharacterList)
        notifyDataSetChanged()
    }

    class CharacterViewHolder(
        private val bindingView: ItemCharacterBinding,
        private val clickListener: (Character) -> Unit
    ) : RecyclerView.ViewHolder(bindingView.root) {

        fun bind(item: Character) {
            bindingView.tv1.text = item.id.toString()
            bindingView.tv2.text = item.name

            Glide
                .with(itemView.context)
                .load(item.image)
                .into(bindingView.tv4)

            itemView.setOnLongClickListener {
                clickListener(item)
                true
            }
        }
    }
}

