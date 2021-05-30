package com.example.marvelclient.avengers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelclient.R
import com.example.marvelclient.adapters.AvengersAdapter
import com.example.marvelclient.databinding.FragmentAvengersBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AvengersFragment : Fragment() {

    private lateinit var binding: FragmentAvengersBinding
    private val viewModel: AvengersViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_avengers, container, false)

        val adapter = AvengersAdapter()
        binding.recView.adapter = adapter
        binding.recView.layoutManager = GridLayoutManager(context,2)

        viewModel.getAvengers().observe(viewLifecycleOwner, Observer {
            it?.let{
                adapter.submitList(it)
            }
        })
        return binding.root
    }
}