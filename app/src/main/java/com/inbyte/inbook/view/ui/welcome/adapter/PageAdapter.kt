package com.inbyte.inbook.view.ui.welcome.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.inbyte.inbook.view.ui.welcome.WelcomeFragment
import com.inbyte.inbook.view.ui.welcome.fragments.WalkThroughScreenOne
import com.inbyte.inbook.view.ui.welcome.fragments.WalkThroughScreenThree
import com.inbyte.inbook.view.ui.welcome.fragments.WalkThroughScreenTwo

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                WalkThroughScreenOne.newInstance()
            }
            1 -> {
                WalkThroughScreenTwo.newInstance()
            }
            2 -> {
                WalkThroughScreenThree.newInstance()
            }
            else -> {
                WalkThroughScreenOne.newInstance()
            }
        }
    }
}