package com.example.databindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.databindingdemo.adapter.ListAdapter;
import com.example.databindingdemo.bean.CelebrityInfo;
import com.example.databindingdemo.databinding.ActivityListBinding;

/**
 * @author yanglijun
 * @date 19-2-18
 */
public class ListActivity extends AppCompatActivity {

    private ActivityListBinding binding;
    private ListAdapter adapter;

    public final ObservableArrayList<CelebrityInfo> listData = new ObservableArrayList<>();

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableInt index = new ObservableInt();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list);

        binding.setActivity(this);

        adapter = new ListAdapter();
        binding.setAdapter(adapter);

        adapter.setData(listData);
        adapter.setItemClickListener(new ListAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View v, int position, CelebrityInfo info) {
                name.set(info.getName());
                index.set(position);
            }
        });

        getCelebrityList();
    }

    public RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            Log.d("ListActivity", "onScrollStateChanged newState:" + newState);
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            Log.d("ListActivity", "onScrolled dx:" + dx + ",dy:" + dy);
        }
    };

    private void getCelebrityList() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                CelebrityInfo brock = new CelebrityInfo();
                brock.setName("布洛克·莱斯纳");
                brock.setWeight(130);
                brock.setRetire(false);
                brock.setIncome(1000);
                brock.setPhoto(R.drawable.brock);
                listData.add(1, brock);
            }
        }, 2000);

        CelebrityInfo dwayne = new CelebrityInfo();
        dwayne.setName("巨石·强森");
        dwayne.setWeight(115);
        dwayne.setRetire(true);
        dwayne.setIncome(2000);
        dwayne.setPhoto(R.drawable.dwayne);
        listData.add(dwayne);

        CelebrityInfo john = new CelebrityInfo();
        john.setName("约翰·塞纳");
        john.setWeight(114);
        john.setRetire(true);
        john.setIncome(1000);
        john.setPhoto(R.drawable.john);
        listData.add(john);

        CelebrityInfo randy = new CelebrityInfo();
        randy.setName("兰迪·奥顿");
        randy.setWeight(111);
        randy.setRetire(false);
        randy.setIncome(999);
        randy.setPhoto(R.drawable.randy);
        listData.add(randy);

        CelebrityInfo roman = new CelebrityInfo();
        roman.setName("罗曼·雷恩斯");
        roman.setWeight(120);
        roman.setRetire(false);
        roman.setIncome(800);
        roman.setPhoto(R.drawable.roman);
        listData.add(roman);
    }
}
