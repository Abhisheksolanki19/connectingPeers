package com.techtroopers.connectingpeers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.techtroopers.connectingpeers.R
import com.techtroopers.connectingpeers.databinding.ActivitySplashBinding
import com.techtroopers.connectingpeers.ui.mycourse.MyCourseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val viewModel: MyCourseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObservers()
    }

    private fun setupObservers(){
        viewModel.enrolledUsersList.observe(this, Observer {
            Toast.makeText(this,it.message, Toast.LENGTH_SHORT).show()
        })
    }
}