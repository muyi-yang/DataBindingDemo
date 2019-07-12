package com.example.databindingdemo.view

import android.content.Context
import android.databinding.InverseBindingListener
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import android.util.AttributeSet

import com.xw.repo.BubbleSeekBar

/**
 * @author yanglijun
 * @date 19-3-12
 */
@InverseBindingMethods(InverseBindingMethod(type = MySeekBar::class, attribute = "progress", event = "progressAttrChanged"))
class MySeekBar : BubbleSeekBar {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    fun setProgressAttrChanged(listener: InverseBindingListener?) {
        if (listener != null) {
            onProgressChangedListener = object : BubbleSeekBar.OnProgressChangedListener {
                override fun onProgressChanged(bubbleSeekBar: BubbleSeekBar, progress: Int, progressFloat: Float, fromUser: Boolean) {
                    listener.onChange()
                }

                override fun getProgressOnActionUp(bubbleSeekBar: BubbleSeekBar, progress: Int,
                                                   progressFloat: Float) {
                }

                override fun getProgressOnFinally(bubbleSeekBar: BubbleSeekBar, progress: Int,
                                                  progressFloat: Float, fromUser: Boolean) {
                }
            }
        }
    }
}
