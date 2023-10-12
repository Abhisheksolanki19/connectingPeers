package com.techtroopers.connectingpeers.ui.fragement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.techtroopers.connectingpeers.R


class UserInputDialogBox : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_input_dialog_box, container, false)
        isCancelable = false

        val submitButton = view.findViewById<Button>(R.id.submitButton)
        val usernameEditText = view.findViewById<EditText>(R.id.usernameEditText)
        val closeButton = view.findViewById<ImageView>(R.id.closeButton)

        submitButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            // Handle the username input here (e.g., send to API).
            // You can pass this data to the hosting activity if needed.
        }

        closeButton.setOnClickListener {
            // Dismiss the dialog when the close button is clicked
            dismiss()
        }
        submitButton.setOnClickListener {
            ApiHitting()
            dismiss()
        }


        return view
    }

    private fun ApiHitting() {
        Toast.makeText(requireContext(), "API", Toast.LENGTH_SHORT).show()
    }
}

