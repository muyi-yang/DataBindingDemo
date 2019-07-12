package com.example.databindingdemo

import android.databinding.DataBindingUtil
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.databinding.ObservableLong
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

import com.example.databindingdemo.databinding.ActivityTwowayBinding

/**
 * @author yanglijun
 * @date 19-3-5
 */
class TwowayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTwowayBinding

    var inputTxt = ObservableField<String>()
    var isTwowayEnable = ObservableBoolean(true)
    var progress = ObservableInt(1)
    var curTime = ObservableLong(System.currentTimeMillis())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_twoway)

        binding.activity = this

        Handler().postDelayed({ progress.set(6) }, 2000)
    }

    fun setDate() {
        binding.tvTime.setText(R.string.date_time)
    }
}
