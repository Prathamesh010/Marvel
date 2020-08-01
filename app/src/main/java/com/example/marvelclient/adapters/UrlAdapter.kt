package com.example.marvelclient.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelclient.R
import com.example.marvelclient.databinding.ListItemUrlBinding
import com.example.marvelclient.model.character.Url


class UrlAdapter(val context: Context): ListAdapter<Url, UrlAdapter.ViewHolder>(
UrlDiffUtil()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListItemUrlBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_url,parent,false)
        return ViewHolder(binding,context)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.url = item
    }

    class ViewHolder(val binding: ListItemUrlBinding,val context: Context): RecyclerView.ViewHolder(binding.root){

        init{
            binding.cardView.setOnClickListener {
                val openUrl = Intent(Intent.ACTION_VIEW,Uri.parse(binding.url?.url))
                context.startActivity(openUrl)
            }
        }

    }
}

class UrlDiffUtil: DiffUtil.ItemCallback<Url>(){
    override fun areItemsTheSame(oldItem: Url, newItem: Url): Boolean {
        return oldItem.type == newItem.type
    }

    override fun areContentsTheSame(oldItem: Url, newItem: Url): Boolean {
        return oldItem == newItem
    }

}