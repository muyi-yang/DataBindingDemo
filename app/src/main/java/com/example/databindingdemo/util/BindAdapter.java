package com.example.databindingdemo.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * @author yanglijun
 * @date 19-2-19
 */
public class BindAdapter {

    @BindingAdapter("app:image")
    public static void bindImage(ImageView view, int resId) {
        view.setImageResource(resId);
    }
}
