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
import com.example.marvelclient.avengers.Avenger
import com.example.marvelclient.databinding.ListItemAvengerBinding

class AvengersAdapter: ListAdapter<Avenger, AvengersAdapter.ViewHolder>(
    AvengerDiffUtil()
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListItemAvengerBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_avenger,parent,false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.avenger = item
    }

    class ViewHolder(val binding: ListItemAvengerBinding): RecyclerView.ViewHolder(binding.root){

        init {
            binding.cardView.setOnClickListener{
                val bundle = bundleOf("id" to binding.avenger?.id)
                it.findNavController().navigate(R.id.characterDetailFragment,bundle)
            }
        }
    }
}

class AvengerDiffUtil: DiffUtil.ItemCallback<Avenger>() {
    override fun areItemsTheSame(oldItem: Avenger, newItem: Avenger): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Avenger, newItem: Avenger): Boolean {
        return oldItem == newItem
    }
}

