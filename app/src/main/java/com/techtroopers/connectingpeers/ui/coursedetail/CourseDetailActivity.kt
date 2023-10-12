package com.techtroopers.connectingpeers.ui.coursedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.tabs.TabLayoutMediator
import com.techtroopers.connectingpeers.R
import com.techtroopers.connectingpeers.comm.Section
import com.techtroopers.connectingpeers.databinding.ActivityCourseDetailBinding
import com.techtroopers.connectingpeers.databinding.ActivitySplashBinding
import com.techtroopers.connectingpeers.ui.coursedetail.adapter.CourseDetailViewPagerAdapter
import com.techtroopers.connectingpeers.ui.mycourse.MyCourseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCourseDetailBinding
    private val viewModel: MyCourseViewModel by viewModels()
    private lateinit var courseDetailViewPagerAdapter: CourseDetailViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObservers()
        setupClickListeners()

        var sectionList : ArrayList<Section> = ArrayList()
        sectionList.add(Section("Description","Description"))
        sectionList.add(Section("All classes","All classes"))
        sectionList.add(Section("Tests","Tests"))
        sectionList.add(Section("Announcements","Announcements"))
        sectionList.add(Section("Peers","Peers"))
        setupAppStoreViewPagerAdapter(sectionList)
    }

    private fun setupObservers(){
        viewModel.enrolledUsersList.observe(this, Observer {
            Toast.makeText(this,it.message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun setupClickListeners(){
        binding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
            finish()
        }
    }

    private fun setupAppStoreViewPagerAdapter(sections: List<Section>) {
        courseDetailViewPagerAdapter = CourseDetailViewPagerAdapter(this, sections)
        binding.viewPager.adapter = courseDetailViewPagerAdapter
        binding.viewPager.offscreenPageLimit = 1
        binding.viewPager.isUserInputEnabled = false
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = sections[position].title
        }.attach()
    }
}