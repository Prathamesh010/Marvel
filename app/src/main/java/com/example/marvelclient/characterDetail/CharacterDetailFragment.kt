package com.example.marvelclient.characterDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.marvelclient.R
import com.example.marvelclient.adapters.CharacterPagerAdapter
import com.example.marvelclient.adapters.MainPagerAdapter
import com.example.marvelclient.avengers.Avenger
import com.example.marvelclient.databinding.CharacterDetailFragmentBinding
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.character_detail_fragment.*
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.IndexOutOfBoundsException

class CharacterDetailFragment : Fragment() {

    private lateinit var binding: CharacterDetailFragmentBinding
    private val viewModel: CharacterDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.character_detail_fragment, container, false)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        val characterId = arguments?.getInt("id")

        var avenger: Avenger? = null
        val fab = binding.add

        binding.lifecycleOwner = this

        setupTabsWithPager(characterId!!)

        viewModel.getCharacter(characterId).observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.character = it
                avenger = Avenger(it.id,it.name,it.thumbnail)
                if(viewModel.ifAvengerExists(it.id)){
                    fab.hide()
                }
            }
        })

        binding.add.setOnClickListener{
               avenger?.let { it1 -> viewModel.addAvenger(it1) }
               Snackbar.make(binding.root,R.string.avenger_added,Snackbar.LENGTH_SHORT).show()
        }

        binding.toolbar.setNavigationOnClickListener{
            it.findNavController().navigateUp()
        }
        return binding.root
    }

    private fun setupTabsWithPager(characterId: Int) {
        val viewPager = binding.viewPager
        val tab = binding.tabs
        viewPager.adapter = CharacterPagerAdapter(this, characterId)

        TabLayoutMediator(tab, viewPager) { tabs, position ->
            tabs.text = getTitle(position)
        }.attach()
    }

    private fun getTitle(position: Int): String{
        return when(position){
            0 -> "About"
            1 -> "Comics"
            else -> throw IndexOutOfBoundsException()
        }
    }
}