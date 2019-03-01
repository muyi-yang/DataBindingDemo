package com.example.databindingdemo.util;

import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.widget.ImageView;

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
}
