package com.example.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.databindingdemo.bean.UserInfo;
import com.example.databindingdemo.databinding.ActivityUserBinding;

/**
 * @author yanglijun
 * @date 19-2-16
 */
public class UserActivity extends AppCompatActivity {

    private ActivityUserBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user);

        UserInfo info = new UserInfo();
        info.name = "木易";
        info.age = 28;
        info.sex = 1;
        info.sign = "问君能有几多愁，恰似一杯二锅头";
        info.avatarId = R.drawable.head;
        binding.setUser(info);

        binding.setIndex(1);

        binding.setActivity(this);

    }

    public void showSign(View v, UserInfo info) {
        Toast.makeText(v.getContext(), info.sign, Toast.LENGTH_LONG).show();
    }

    public boolean showSign(UserInfo info) {
        Toast.makeText(this, info.sign, Toast.LENGTH_LONG).show();
        return true;
    }
}
