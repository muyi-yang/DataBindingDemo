package com.example.databindingdemo.util;

import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


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

}
