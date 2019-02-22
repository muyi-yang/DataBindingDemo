package com.example.databindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableInt index = new ObservableInt();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list);

        binding.setActivity(this);

        adapter = new ListAdapter();
        binding.setAdapter(adapter);

        adapter.setData(getCelebrityList());
        adapter.setItemClickListener(new ListAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View v, int position, CelebrityInfo info) {
                name.set(info.getName());
                index.set(position);
            }
        });
    }

    private List<CelebrityInfo> getCelebrityList() {
        List<CelebrityInfo> list = new ArrayList<>();
        CelebrityInfo brock = new CelebrityInfo();
        brock.setName("布洛克·莱斯纳");
        brock.setWeight(130);
        brock.setRetire(false);
        brock.setIncome(1000);
        brock.setPhoto(R.drawable.brock);
        list.add(brock);

        CelebrityInfo dwayne = new CelebrityInfo();
        dwayne.setName("巨石·强森");
        dwayne.setWeight(115);
        dwayne.setRetire(true);
        dwayne.setIncome(2000);
        dwayne.setPhoto(R.drawable.dwayne);
        list.add(dwayne);

        CelebrityInfo john = new CelebrityInfo();
        john.setName("约翰·塞纳");
        john.setWeight(114);
        john.setRetire(true);
        john.setIncome(1000);
        john.setPhoto(R.drawable.john);
        list.add(john);

        CelebrityInfo randy = new CelebrityInfo();
        randy.setName("兰迪·奥顿");
        randy.setWeight(111);
        randy.setRetire(false);
        randy.setIncome(999);
        randy.setPhoto(R.drawable.randy);
        list.add(randy);

        CelebrityInfo roman = new CelebrityInfo();
        roman.setName("罗曼·雷恩斯");
        roman.setWeight(120);
        roman.setRetire(false);
        roman.setIncome(800);
        roman.setPhoto(R.drawable.roman);
        list.add(roman);
        return list;
    }
}
