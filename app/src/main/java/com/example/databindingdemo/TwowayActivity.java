package com.example.databindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Bundle;
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

//    public CompoundButton.OnCheckedChangeListener listener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_twoway);

        binding.setActivity(this);
    }
}
