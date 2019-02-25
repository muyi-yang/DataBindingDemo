package com.example.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
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
        binding.tvInfo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }

    public void userClick(View view) {
        startActivity(new Intent(this, UserActivity.class));
    }

    public void startList() {
        startActivity(new Intent(this, ListActivity.class));
    }

    public void startBindingClass() {
        startActivity(new Intent(this, BindingClassActivity.class));
    }

    public boolean listLongClick() {
        //长按操作
        return true;
    }
}
