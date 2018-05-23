package com.wxf.language

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by dengjun on 2018/5/23/023.
 */
class TestFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.test_fragment, container, false)
        (v.findViewById(R.id.pager) as ViewPager).adapter = object : FragmentPagerAdapter(childFragmentManager) {
            override fun getItem(position: Int)=Fragment.instantiate(context!!, TestFragment1::class.java.name)

            override fun getCount() = 300
        }
        return v
    }
}