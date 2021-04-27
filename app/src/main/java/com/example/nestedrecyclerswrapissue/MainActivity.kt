package com.example.nestedrecyclerswrapissue

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nestedrecyclerswrapissue.ListActivity.Companion.PARAM_USES_CUSTOM_LAYOUT_MANAGER_FLAG
import com.example.nestedrecyclerswrapissue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpButtons()
    }

    private fun setUpButtons() {
        binding.bugCaseButton.setOnClickListener {
            startListActivity(usesCustomLayoutManager = false)
        }
        binding.alternativeLMCaseButton.setOnClickListener {
            startListActivity(usesCustomLayoutManager = true)
        }
    }

    private fun startListActivity(usesCustomLayoutManager: Boolean) {
        val intent = Intent(this, ListActivity::class.java).apply {
            putExtra(PARAM_USES_CUSTOM_LAYOUT_MANAGER_FLAG, usesCustomLayoutManager)
        }
        startActivity(intent)
    }
}