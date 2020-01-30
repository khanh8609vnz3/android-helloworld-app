package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

const val EXTRA_MESSAGE = "com.example.helloworld.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Call function when user tap the send button
    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editText1);
        val message = editText.text.toString();
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE,message);
        }
        startActivity(intent);
    }
}
