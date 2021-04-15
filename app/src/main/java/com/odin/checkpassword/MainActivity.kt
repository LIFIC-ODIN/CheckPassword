package com.odin.checkpassword

import android.os.Bundle
import androidx.activity.viewModels
import com.odin.checkpassword.base.BaseActivity
import com.odin.checkpassword.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
    }

    private fun setupBinding() {
        binding.run {
            viewModel = mainViewModel
        }
    }
}