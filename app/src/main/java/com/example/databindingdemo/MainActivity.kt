package com.example.databindingdemo

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

import com.example.databindingdemo.databinding.ActivityMainBinding

/**
 * @author yanglijun
 * @date 19-2-16
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.tvInfo.text = "我是使用Data Binding的Demo"
        binding.activity = this
        binding.tvInfo.setOnLongClickListener { false }
    }

    fun userClick(view: View) {
        startActivity(Intent(this, UserActivity::class.java))
    }

    fun startList() {
        startActivity(Intent(this, ListActivity::class.java))
    }

    fun startBindingClass() {
        startActivity(Intent(this, BindingClassActivity::class.java))
    }

    fun startBindingAdapter() {
        startActivity(Intent(this, AdapterActivity::class.java))
    }

    fun startBindingTwoway() {
        startActivity(Intent(this, TwowayActivity::class.java))
    }

    fun listLongClick(): Boolean {
        //长按操作
        return true
    }
}
