package com.example.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.databindingdemo.databinding.ActivityMainBinding;

/**
 * @author yanglijun
 * @date 19-2-16
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.tvInfo.setText("我是使用Data Binding的Demo");
        binding.setActivity(this);
    }

    public void userClick(View view){
        startActivity(new Intent(this, UserActivity.class));
    }
}
