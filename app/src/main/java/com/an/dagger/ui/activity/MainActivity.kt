package com.an.dagger.ui.activity

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import com.an.dagger.databinding.MainActivityBinding
import com.an.dagger.R
import com.an.dagger.ui.base.BaseActivity

class MainActivity : BaseActivity() {


    /*
     * I am using DataBinding
     * */
    private lateinit var binding: MainActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiseView()
    }


    /*
     * Initialising the View using Data Binding
     * */
    private fun initialiseView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    fun updateBackground(url: String?) {
        binding.overlayLayout.updateCurrentBackground(url)
    }
}