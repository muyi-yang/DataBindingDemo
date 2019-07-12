package com.example.databindingdemo

import android.databinding.DataBindingUtil
import android.databinding.adapters.ViewBindingAdapter
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

import com.example.databindingdemo.databinding.ActivityAdapterBinding

/**
 * @author yanglijun
 * @date 19-3-1
 */
class AdapterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdapterBinding
    private val handler = Handler()

    private val attached = ViewBindingAdapter.OnViewAttachedToWindow { toast("视图被添加到窗口中") }

    private val detached = ViewBindingAdapter.OnViewDetachedFromWindow { toast("视图从窗口中被移除") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_adapter)

        binding.tintColor = resources.getColorStateList(R.color.colorAccent)

        binding.imgUrl = "https://s2.ax1x.com/2019/03/03/kLWJ3D.jpg"

        binding.switchUrl = "https://s2.ax1x.com/2019/03/03/kLWJ3D.jpg"
        handler.postDelayed({ binding.switchUrl = "https://s2.ax1x.com/2019/03/03/kLOdSA.jpg" }, 2000)
        handler.postDelayed({ binding.switchUrl = "https://s2.ax1x.com/2019/03/03/kLOdSA.jpg" }, 4000)

        binding.attachListener = attached
        binding.detachListener = detached

        handler.postDelayed({ binding.isShow = true }, 1000)
    }

    private fun toast(content: String) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show()
    }
}
