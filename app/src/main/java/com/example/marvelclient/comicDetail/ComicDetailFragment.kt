package com.example.marvelclient.comicDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelclient.R
import com.example.marvelclient.adapters.*
import com.example.marvelclient.characterDetail.CharacterDetailFragmentArgs
import com.example.marvelclient.comic.ComicViewModel
import com.example.marvelclient.databinding.ComicDetailFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.IndexOutOfBoundsException

class ComicDetailFragment : Fragment() {

    private lateinit var binding: ComicDetailFragmentBinding
    private val viewModel: ComicDetailViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.comic_detail_fragment,container,false)
        val argument = arguments?.getInt("id")

        val urlAdapter = UrlAdapter(requireContext())
        val imageAdapter = ImageAdapter()
        binding.infoRecView.adapter = urlAdapter
        binding.imageRecView.adapter = imageAdapter
        binding.imageRecView.layoutManager = GridLayoutManager(context,3)
        binding.imageRecView.isNestedScrollingEnabled = false
        binding.infoRecView.isNestedScrollingEnabled = false

        viewModel.getComic(argument!!).observe(viewLifecycleOwner,Observer{
            it?.let {
                binding.comic = it
                urlAdapter.submitList(it.urls)
                imageAdapter.submitList(it.images)
            }
        })

        return binding.root
    }
}