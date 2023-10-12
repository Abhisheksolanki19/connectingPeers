package com.techtroopers.connectingpeers.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.techtroopers.connectingpeers.databinding.ActivityCourseBinding

class CourseActivity : AppCompatActivity() {
    lateinit var binding: ActivityCourseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpClick()
    }
    private fun setUpClick(){
        binding.bvButton.setOnClickListener{
            Toast.makeText(this, "Enrool now", Toast.LENGTH_SHORT).show()
        }

    }
   }

