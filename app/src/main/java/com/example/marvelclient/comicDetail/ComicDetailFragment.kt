package com.example.marvelclient.comicDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelclient.R
import com.example.marvelclient.adapters.ImageAdapter
import com.example.marvelclient.adapters.UrlAdapter
import com.example.marvelclient.databinding.ComicDetailFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComicDetailFragment : Fragment() {

    private lateinit var binding: ComicDetailFragmentBinding
    private val viewModel: ComicDetailViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.comic_detail_fragment,container,false)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
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

        binding.toolbar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }

        return binding.root
    }
}