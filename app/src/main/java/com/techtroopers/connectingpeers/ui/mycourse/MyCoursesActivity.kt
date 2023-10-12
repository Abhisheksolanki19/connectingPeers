package com.techtroopers.connectingpeers.ui.mycourse

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.techtroopers.connectingpeers.databinding.ActivityMyCourseBinding
import com.techtroopers.connectingpeers.ui.coursedetail.CourseDetailActivity

class MyCoursesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpClick()
    }

    private fun setUpClick() {
        binding.bvButton.setOnClickListener {
            startActivity(Intent(this,CourseDetailActivity::class.java))
        }

    }

}