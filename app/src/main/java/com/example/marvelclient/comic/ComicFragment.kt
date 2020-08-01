package com.example.marvelclient.comic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelclient.R
import com.example.marvelclient.adapters.ComicAdapter
import com.example.marvelclient.databinding.ComicFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComicFragment : Fragment() {

    private lateinit var binding: ComicFragmentBinding
    private val viewModel: ComicViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.comic_fragment,container,false)
        binding.recView.layoutManager = GridLayoutManager(context,2)
        binding.lifecycleOwner = this
        val adapter = ComicAdapter()
        binding.recView.adapter = adapter

        viewModel.getComics().observe(viewLifecycleOwner, Observer {
            if(it != null){
                adapter.submitList(it)
                if(it.isNotEmpty())
                    binding.progressBar.visibility = View.GONE
            }
        })
        return binding.root
    }
}