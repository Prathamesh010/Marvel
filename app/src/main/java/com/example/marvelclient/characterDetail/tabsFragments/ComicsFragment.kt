package com.example.marvelclient.characterDetail.tabsFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelclient.R
import com.example.marvelclient.adapters.ComicAdapter
import com.example.marvelclient.characterDetail.CharacterDetailFragmentArgs
import com.example.marvelclient.characterDetail.CharacterDetailViewModel
import com.example.marvelclient.databinding.FragmentComicsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComicsFragment() : Fragment() {

    companion object{
        @JvmStatic
        fun newInstance(id: Int) = ComicsFragment().apply {
            arguments = Bundle().apply {
                putInt("id",id)
            }
        }
    }

    private lateinit var  binding: FragmentComicsBinding
    private val viewModel: CharacterDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_comics,container,false)
        val characterId = arguments?.getInt("id")
        val adapter = ComicAdapter()
        binding.recView.adapter = adapter
        binding.recView.layoutManager = GridLayoutManager(context,2)

        viewModel.getCharacterComics(characterId!!)
        viewModel.characterComics.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
                if(it.isNotEmpty())
                    binding.progressBar.visibility = View.GONE
            }
        })

        return binding.root
    }
}