package com.example.marvelclient.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelclient.R
import com.example.marvelclient.databinding.ListItemCharacterBinding
import com.example.marvelclient.model.character.Character

class CharacterAdapter: ListAdapter<Character, CharacterAdapter.ViewHolder>(
    CharacterDiffUtil()
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListItemCharacterBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.list_item_character,parent,false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.character = item
    }

    class ViewHolder(val binding: ListItemCharacterBinding): RecyclerView.ViewHolder(binding.root){

        init{
            binding.cardView.setOnClickListener {
                val bundle = bundleOf("id" to binding.character?.id)
                it.findNavController().navigate(R.id.characterDetailFragment,bundle)
            }
        }

    }
}

class CharacterDiffUtil: DiffUtil.ItemCallback<Character>(){
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }

}