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
import com.example.marvelclient.databinding.ListItemComicBinding
import com.example.marvelclient.model.comic.Comic

class ComicAdapter: ListAdapter<Comic, ComicAdapter.ViewHolder>(
    ComicDiffUtil()
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListItemComicBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context)
            , R.layout.list_item_comic,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.comic = getItem(position)
    }

    class ViewHolder(val binding: ListItemComicBinding): RecyclerView.ViewHolder(binding.root){
        init {
            binding.cardView.setOnClickListener{
                val bundle = bundleOf("id" to binding.comic?.id)
                it.findNavController().navigate(R.id.comicDetailFragment,bundle)
            }
        }
    }
}

class ComicDiffUtil(): DiffUtil.ItemCallback<Comic>(){
    override fun areItemsTheSame(oldItem: Comic, newItem: Comic): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Comic, newItem: Comic): Boolean {
        return oldItem == newItem
    }

}