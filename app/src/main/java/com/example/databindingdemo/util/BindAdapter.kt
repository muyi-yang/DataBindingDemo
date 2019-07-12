package com.example.databindingdemo.util

import android.databinding.BindingAdapter
import android.databinding.BindingConversion
import android.databinding.BindingMethod
import android.databinding.BindingMethods
import android.databinding.InverseBindingAdapter
import android.databinding.InverseBindingListener
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.view.View
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.xw.repo.BubbleSeekBar


/**
 * @author yanglijun
 * @date 19-2-19
 */
@BindingMethods(BindingMethod(type = android.widget.ImageView::class, attribute = "android:tint", method = "setImageTintList"))
object BindAdapter {

    @BindingAdapter("image")
    @JvmStatic
    fun bindImage(view: ImageView, resId: Int) {
        view.setImageResource(resId)
    }

    //    @BindingAdapter({"app:image", "app:error"})
    //    public static void loadImage(ImageView view, String url, Drawable error) {
    //        RequestOptions options = new RequestOptions().error(error);
    //        Glide.with(view).load(url).apply(options).into(view);
    //    }

    @BindingAdapter(value = ["image", "placeholder", "error"], requireAll = false)
    @JvmStatic
    fun loadImage(view: ImageView, url: String, placeholder: Drawable, error: Drawable) {
        if (TextUtils.isEmpty(url)) {
            view.setImageDrawable(placeholder)
        } else {
            val options = RequestOptions().placeholder(placeholder).error(error)
            Glide.with(view).load(url).apply(options).into(view)
        }
    }

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun bindImage(view: ImageView, oldUrl: String?, newUrl: String) {
        if (oldUrl == null || oldUrl != newUrl) {
            Glide.with(view).load(newUrl).into(view)
        }
    }

    @BindingConversion
    @JvmStatic
    fun convertBooleanToVisible(visible: Boolean): Int {
        return if (visible) View.VISIBLE else View.GONE
    }

    //因为 setter 方法自动匹配所以无需适配器
    //    @BindingAdapter("app:progress")
    //    public static void setProgress(BubbleSeekBar seekBar, int progress){
    //        if(seekBar.getProgress() != progress){
    //            seekBar.setProgress(progress);
    //        }
    //    }

    @InverseBindingAdapter(attribute = "progress", event = "progressChanged")
    @JvmStatic
    fun getProgress(seekBar: BubbleSeekBar): Int {
        return seekBar.progress
    }

    @BindingAdapter("progressChanged")
    @JvmStatic
    fun setProgressListener(seekBar: BubbleSeekBar,
                            listener: InverseBindingListener) {
        seekBar.onProgressChangedListener = object : BubbleSeekBar.OnProgressChangedListener {
            override fun onProgressChanged(bubbleSeekBar: BubbleSeekBar, progress: Int,
                                           progressFloat: Float, fromUser: Boolean) {
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

    //    合并的写法
    //    @BindingAdapter(value = {"app:progress", "app:progressChanged"}, requireAll = false)
    //    public static void setProgress(BubbleSeekBar seekBar, int progress, final InverseBindingListener listener) {
    //        if(seekBar.getProgress() != progress){
    //            seekBar.setProgress(progress);
    //        }
    //        seekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
    //            @Override
    //            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress,
    //                                          float progressFloat, boolean fromUser) {
    //                listener.onChange();
    //            }
    //
    //            @Override
    //            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress,
    //                                              float progressFloat) {
    //            }
    //
    //            @Override
    //            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress,
    //                                             float progressFloat, boolean fromUser) {
    //            }
    //        });
    //    }
}
