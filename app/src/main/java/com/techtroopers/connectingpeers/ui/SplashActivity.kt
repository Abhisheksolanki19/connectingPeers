package com.techtroopers.connectingpeers.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.techtroopers.connectingpeers.databinding.ActivitySplashBinding
import com.techtroopers.connectingpeers.ui.coursedetail.CourseDetailActivity
import com.techtroopers.connectingpeers.ui.mycourse.MyCoursesActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    val SPLASH_DELAY: Long = 2000 // 2 seconds


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        moveToNextScreen()
        startActivity(Intent(this, CourseDetailActivity::class.java))
    }

    private fun moveToNextScreen() {
        Handler().postDelayed({
            // Start the MainActivity
            val mainIntent = Intent(this, MyCoursesActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_DELAY)
    }
}