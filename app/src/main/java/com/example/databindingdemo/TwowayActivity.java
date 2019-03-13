package com.example.databindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ObservableLong;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.databindingdemo.databinding.ActivityTwowayBinding;

/**
 * @author yanglijun
 * @date 19-3-5
 */
public class TwowayActivity extends AppCompatActivity {

    private ActivityTwowayBinding binding;

    public ObservableField<String> inputTxt = new ObservableField<>();
    public ObservableBoolean isTwowayEnable = new ObservableBoolean(true);
    public ObservableInt progress = new ObservableInt(1);
    public ObservableLong curTime = new ObservableLong(System.currentTimeMillis());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_twoway);

        binding.setActivity(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progress.set(6);
            }
        }, 2000);
    }

    public void setDate(){
        binding.tvTime.setText(R.string.date_time);
    }
}
