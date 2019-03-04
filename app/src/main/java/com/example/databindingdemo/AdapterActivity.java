package com.example.databindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.adapters.ViewBindingAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.databindingdemo.databinding.ActivityAdapterBinding;

/**
 * @author yanglijun
 * @date 19-3-1
 */
public class AdapterActivity extends AppCompatActivity {

    private ActivityAdapterBinding binding;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_adapter);

        binding.setTintColor(getResources().getColorStateList(R.color.colorAccent));

        binding.setImgUrl("https://s2.ax1x.com/2019/03/03/kLWJ3D.jpg");

        binding.setSwitchUrl("https://s2.ax1x.com/2019/03/03/kLWJ3D.jpg");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.setSwitchUrl("https://s2.ax1x.com/2019/03/03/kLOdSA.jpg");
            }
        }, 2000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.setSwitchUrl("https://s2.ax1x.com/2019/03/03/kLOdSA.jpg");
            }
        }, 4000);

        binding.setAttachListener(attached);
        binding.setDetachListener(detached);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.setIsShow(true);
            }
        }, 1000);
    }

    private ViewBindingAdapter.OnViewAttachedToWindow attached = new ViewBindingAdapter.OnViewAttachedToWindow() {
        @Override
        public void onViewAttachedToWindow(View v) {
            toast("视图被添加到窗口中");
        }
    };

    private ViewBindingAdapter.OnViewDetachedFromWindow detached = new ViewBindingAdapter.OnViewDetachedFromWindow() {
        @Override
        public void onViewDetachedFromWindow(View v) {
            toast("视图从窗口中被移除");
        }
    };

    private void toast(String content){
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }
}
