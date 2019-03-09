package com.example.databindingdemo.util;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.xw.repo.BubbleSeekBar;


/**
 * @author yanglijun
 * @date 19-2-19
 */
@BindingMethods({@BindingMethod(type = android.widget.ImageView.class, attribute = "android:tint",
        method = "setImageTintList")})
public class BindAdapter {

    @BindingAdapter("app:image")
    public static void bindImage(ImageView view, int resId) {
        view.setImageResource(resId);
    }

//    @BindingAdapter({"app:image", "app:error"})
//    public static void loadImage(ImageView view, String url, Drawable error) {
//        RequestOptions options = new RequestOptions().error(error);
//        Glide.with(view).load(url).apply(options).into(view);
//    }

    @BindingAdapter(value = {"app:image", "app:placeholder", "app:error"}, requireAll = false)
    public static void loadImage(ImageView view, String url, Drawable placeholder, Drawable error) {
        if (TextUtils.isEmpty(url)) {
            view.setImageDrawable(placeholder);
        } else {
            RequestOptions options = new RequestOptions().placeholder(placeholder).error(error);
            Glide.with(view).load(url).apply(options).into(view);
        }
    }

    @BindingAdapter("app:imageUrl")
    public static void bindImage(ImageView view, String oldUrl, String newUrl) {
        if (oldUrl == null || !oldUrl.equals(newUrl)) {
            Glide.with(view).load(newUrl).into(view);
        }
    }

    @BindingConversion
    public static int convertBooleanToVisible(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }

    //因为 setter 方法自动匹配所以无需适配器
//    @BindingAdapter("app:progress")
//    public static void setProgress(BubbleSeekBar seekBar, int progress){
//        seekBar.setProgress(progress);
//    }

    @InverseBindingAdapter(attribute = "app:progress", event = "app:progressChanged")
    public static int getProgress(BubbleSeekBar seekBar) {
        return seekBar.getProgress();
    }

    @BindingAdapter("app:progressChanged")
    public static void setProgressListener(BubbleSeekBar seekBar,
                                           final InverseBindingListener listener) {
        seekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress,
                                          float progressFloat, boolean fromUser) {
                listener.onChange();
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress,
                                              float progressFloat) {
            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress,
                                             float progressFloat, boolean fromUser) {
            }
        });
    }
}
