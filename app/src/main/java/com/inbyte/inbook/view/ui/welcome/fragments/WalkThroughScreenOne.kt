package com.inbyte.inbook.view.ui.welcome.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inbyte.inbook.R


class WalkThroughScreenOne : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_walk_through_screen_one, container, false)
    }


    companion object {
        fun newInstance(): Fragment {
            return WalkThroughScreenTwo()
        }
    }

}