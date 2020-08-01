package com.example.marvelclient.character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelclient.R
import com.example.marvelclient.adapters.CharacterAdapter
import com.example.marvelclient.databinding.CharacterFragmentBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : Fragment() {
    private lateinit var binding: CharacterFragmentBinding
    private val viewModel: CharacterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.character_fragment,container,false)
        val adapter = CharacterAdapter()
        binding.recView.layoutManager = GridLayoutManager(context,2)
        binding.recView.adapter = adapter

        viewModel.getCharacters().observe(viewLifecycleOwner, Observer {
            it?.let{
                adapter.submitList(it)
                if(it.isNotEmpty())
                    binding.progressBar.visibility = View.GONE
            }
        })
        return binding.root
    }
}