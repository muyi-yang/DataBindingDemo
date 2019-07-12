package com.example.databindingdemo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

import com.example.databindingdemo.bean.UserInfo
import com.example.databindingdemo.databinding.ActivityUserBinding

/**
 * @author yanglijun
 * @date 19-2-16
 */
class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user)

        val info = UserInfo()
        info.name = "木易"
        info.age = 28
        info.sex = 1
        info.sign = "问君能有几多愁，恰似一杯二锅头"
        info.avatarId = R.drawable.head
        binding.user = info

        binding.index = 1

        binding.activity = this

        binding.stringResId = R.string.app_name
    }

    fun showSign(v: View, info: UserInfo) {
        Toast.makeText(v.context, info.sign, Toast.LENGTH_LONG).show()
    }

    fun showSign(info: UserInfo): Boolean {
        Toast.makeText(this, info.sign, Toast.LENGTH_LONG).show()
        return true
    }
}
