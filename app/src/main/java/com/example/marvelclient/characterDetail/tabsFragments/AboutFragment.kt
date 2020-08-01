package com.example.marvelclient.characterDetail.tabsFragments

import android.icu.lang.UCharacter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelclient.R
import com.example.marvelclient.adapters.UrlAdapter
import com.example.marvelclient.characterDetail.CharacterDetailViewModel
import com.example.marvelclient.databinding.FragmentAboutBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AboutFragment() : Fragment() {

    companion object{
        @JvmStatic
        fun newInstance(id: Int) = AboutFragment().apply {
            arguments = Bundle().apply {
                putInt("id",id)
            }
        }
    }

    private lateinit var binding: FragmentAboutBinding
    private val viewModel: CharacterDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val id = arguments?.getInt("id")
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_about, container, false)

        val adapter = UrlAdapter(requireContext())
        binding.recView.adapter = adapter
        binding.recView.layoutManager = LinearLayoutManager(context)


        viewModel.getCharacter(id!!).observe(viewLifecycleOwner, Observer {
            it?.let{
                binding.character = it
                adapter.submitList(it.urls)
            }
        })

        return binding.root
    }
}