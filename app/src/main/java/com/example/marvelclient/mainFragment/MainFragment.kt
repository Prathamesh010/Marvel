package com.example.marvelclient.mainFragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.marvelclient.R
import com.example.marvelclient.adapters.MainPagerAdapter
import com.example.marvelclient.databinding.MainFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.IndexOutOfBoundsException

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.main_fragment,container,false)

        setupTabWithPager()

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun setupTabWithPager() {
        val viewPager = binding.viewPager
        val tab = binding.tabs
        viewPager.adapter = MainPagerAdapter(this)

        TabLayoutMediator(tab, viewPager) { tabs, position ->
            tabs.text = getTitle(position)
        }.attach()
    }

    private fun getTitle(position: Int): String{
        return when(position){
            0 -> "Characters"
            1 -> "Comics"
            else -> throw IndexOutOfBoundsException()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}