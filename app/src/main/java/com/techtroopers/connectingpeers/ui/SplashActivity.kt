package com.techtroopers.connectingpeers.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.techtroopers.connectingpeers.R
import com.techtroopers.connectingpeers.databinding.ActivitySplashBinding
import com.techtroopers.connectingpeers.ui.mycourse.MyCourseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val viewModel: MyCourseViewModel by viewModels()

    private val SPLASH_DURATION = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.enrolledUsersList.observe(this, Observer {
            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
        })
        setContentView(R.layout.activity_splash)
        moveToNextScreen()
    }
    private fun moveToNextScreen(){
        startActivity(Intent(this,CourseActivity::class.java))
    }
}