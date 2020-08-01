package com.example.marvelclient.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.marvelclient.character.CharacterFragment
import com.example.marvelclient.comic.ComicFragment
import java.lang.IndexOutOfBoundsException

class MainPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment){
    private val fragments: Map<Int,() -> Fragment> = mapOf(
        0 to {CharacterFragment()},
        1 to {ComicFragment()}
    )

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}