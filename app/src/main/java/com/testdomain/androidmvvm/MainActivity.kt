package com.testdomain.androidmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.testdomain.androidmvvm.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }


        Log.d("MainActivity", "onCreate state:" + lifecycle.currentState)
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart state:" + lifecycle.currentState)
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume state:" + lifecycle.currentState)
    }

    override fun onPostResume() { // onPostResume()はonResumeの後に呼ばれます。
        super.onPostResume()
        Log.d("MainActivity", "onPostResume state:" + lifecycle.currentState)
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause state:"+lifecycle.currentState)
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop state:"+lifecycle.currentState)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy state:"+lifecycle.currentState)
    }

}