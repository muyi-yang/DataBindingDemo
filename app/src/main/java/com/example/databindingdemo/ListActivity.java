package com.example.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.databindingdemo.bean.CelebrityInfo;
import com.example.databindingdemo.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanglijun
 * @date 19-2-18
 */
public class ListActivity extends AppCompatActivity {

    private ActivityListBinding binding;
    private ListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list);

        binding.setActivity(this);

        adapter = new ListAdapter();
        binding.setAdapter(adapter);

        adapter.setData(getCelebrityList());
    }

    private List<CelebrityInfo> getCelebrityList() {
        List<CelebrityInfo> list = new ArrayList<>();
        CelebrityInfo brock = new CelebrityInfo();
        brock.name.set("布洛克·莱斯纳");
        brock.weight.set(130);
        brock.isRetire.set(false);
        brock.income.set(1000);
        brock.photo.set(R.drawable.brock);
        list.add(brock);

        CelebrityInfo dwayne = new CelebrityInfo();
        dwayne.name.set("巨石·强森");
        dwayne.weight.set(115);
        dwayne.isRetire.set(true);
        dwayne.income.set(2000);
        dwayne.photo.set(R.drawable.dwayne);
        list.add(dwayne);

        CelebrityInfo john = new CelebrityInfo();
        john.name.set("约翰·塞纳");
        john.weight.set(114);
        john.isRetire.set(true);
        john.income.set(1000);
        john.photo.set(R.drawable.john);
        list.add(john);

        CelebrityInfo randy = new CelebrityInfo();
        randy.name.set("兰迪·奥顿");
        randy.weight.set(111);
        randy.isRetire.set(false);
        randy.income.set(999);
        randy.photo.set(R.drawable.randy);
        list.add(randy);

        CelebrityInfo roman = new CelebrityInfo();
        roman.name.set("罗曼·雷恩斯");
        roman.weight.set(120);
        roman.isRetire.set(false);
        roman.income.set(800);
        roman.photo.set(R.drawable.roman);
        list.add(roman);
        return list;
    }
}
