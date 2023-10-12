package com.techtroopers.connectingpeers.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.techtroopers.connectingpeers.R
import com.techtroopers.connectingpeers.databinding.ActivitySplashBinding
import com.techtroopers.connectingpeers.ui.coursedetail.CourseDetailActivity
import com.techtroopers.connectingpeers.ui.mycourse.MyCourseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val viewModel: MyCourseViewModel by viewModels()
    val SPLASH_DELAY: Long = 2000 // 2 seconds


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObservers()
        startActivity(Intent(this,CourseDetailActivity::class.java))
    }

    private fun setupObservers() {
        viewModel.enrolledUsersList.observe(this, Observer {
            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
        })
        setContentView(R.layout.activity_splash)
        moveToNextScreen()
    }
    private fun moveToNextScreen(){
        Handler().postDelayed({
            // Start the MainActivity
            val mainIntent = Intent(this, CourseActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_DELAY)
    }
}