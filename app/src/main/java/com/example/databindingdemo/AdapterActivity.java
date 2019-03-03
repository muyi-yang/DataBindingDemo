package com.example.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.databindingdemo.databinding.ActivityAdapterBinding;

/**
 * @author yanglijun
 * @date 19-3-1
 */
public class AdapterActivity extends AppCompatActivity {

    private ActivityAdapterBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_adapter);

        binding.setTintColor(getResources().getColorStateList(R.color.colorAccent));

        binding.setImgUrl("https://s2.ax1x.com/2019/03/03/kLWJ3D.jpg");

    }
}
