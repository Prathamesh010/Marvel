package com.example.marvelclient.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.marvelclient.characterDetail.tabsFragments.AboutFragment
import com.example.marvelclient.characterDetail.tabsFragments.ComicsFragment

class CharacterPagerAdapter(fragment: Fragment,private val id: Int): FragmentStateAdapter(fragment){
    private val fragments: Map<Int,() -> Fragment> = mapOf(
        0 to { AboutFragment.newInstance(id) },
        1 to { ComicsFragment.newInstance(id)}
    )

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}