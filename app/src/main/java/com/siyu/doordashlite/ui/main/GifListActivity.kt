package com.siyu.doordashlite.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.siyu.doordashlite.R

class GifListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, GifListFragment.newInstance())
                .commitNow()
        }
    }

}
