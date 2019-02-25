package com.example.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;

import com.example.databindingdemo.databinding.ActivityBindingBinding;
import com.example.databindingdemo.databinding.LayoutBarBinding;

/**
 * @author yanglijun
 * @date 19-2-25
 */
public class BindingClassActivity extends AppCompatActivity {

    private ActivityBindingBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding);
        binding.vsBar.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                LayoutBarBinding vsBarBinding = DataBindingUtil.bind(inflated);
                vsBarBinding.setName("木易");
                vsBarBinding.setResId(R.drawable.head);
            }
        });
        binding.setActivity(this);
    }

    public void showViewStub() {
        ViewStub viewStub = binding.vsBar.getViewStub();
        if (viewStub != null) {
            viewStub.inflate();
        }
    }
}
