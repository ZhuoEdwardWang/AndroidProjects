package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
        binding.nicknameText.setOnClickListener {
            updateNickName(it)
        }
        binding.editNickName.setOnClickListener {
            typingNickName(it)
        }
    }

    private fun addNickName(view: View) {
        val editText = binding.editNickName
        val nicknameTextView = binding.nicknameText
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickName(view: View) {
        val editText = binding.editNickName
        val doneButton = binding.doneButton
        editText.text = null
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
    }

    private fun typingNickName(view: View) {
        val editText = binding.editNickName
        if (editText.hasFocus()){
            editText.hint = null
        }
        else{
            editText.hint = R.string.whats_your_nickname.toString()
        }
    }
}