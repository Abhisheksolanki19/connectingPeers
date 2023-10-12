package com.techtroopers.connectingpeers.ui.coursedetail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.techtroopers.connectingpeers.comm.Section
import com.techtroopers.connectingpeers.ui.coursedetail.adapter.coursedetail.CourseDetailFragment

class CourseDetailViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val sections: List<Section>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = sections.size

    override fun createFragment(position: Int): Fragment {
        return CourseDetailFragment.newInstance(sections[position])
    }

}