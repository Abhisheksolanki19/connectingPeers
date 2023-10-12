package com.techtroopers.connectingpeers.ui.mycourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.techtroopers.connectingpeers.databinding.ActivityMyCourseBinding
import com.techtroopers.connectingpeers.ui.fragement.UserInputDialogBox

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
            val bottomSheetFragment = UserInputDialogBox()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }

    }

}