package com.techtroopers.connectingpeers.ui.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.techtroopers.connectingpeers.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpClick()
    }
    private fun setUpClick(){
        binding.ivBackButton.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}