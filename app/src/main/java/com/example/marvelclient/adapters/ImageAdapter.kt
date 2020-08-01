package com.example.marvelclient.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelclient.R
import com.example.marvelclient.databinding.ListItemImagesBinding
import com.example.marvelclient.model.Thumbnail


class ImageAdapter: ListAdapter<Thumbnail, ImageAdapter.ViewHolder>(
    ImageDiffUtil()
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListItemImagesBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context)
            , R.layout.list_item_images,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.thumbnail = getItem(position)
    }

    class ViewHolder(val binding: ListItemImagesBinding): RecyclerView.ViewHolder(binding.root){}
}

class ImageDiffUtil(): DiffUtil.ItemCallback<Thumbnail>(){
    override fun areItemsTheSame(oldItem: Thumbnail, newItem: Thumbnail): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Thumbnail, newItem: Thumbnail): Boolean {
        return oldItem == newItem
    }

}