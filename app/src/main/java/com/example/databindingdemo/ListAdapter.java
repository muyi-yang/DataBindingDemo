package com.example.databindingdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.databindingdemo.bean.CelebrityInfo;
import com.example.databindingdemo.databinding.LayoutCelebrityItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanglijun
 * @date 19-2-22
 */
public class ListAdapter extends RecyclerView.Adapter {

    private List<CelebrityInfo> data = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        LayoutCelebrityItemBinding binding = LayoutCelebrityItemBinding
                .inflate(inflater, viewGroup, false);
        return new MyViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder holder = (MyViewHolder) viewHolder;
        holder.binding.setInfo(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<CelebrityInfo> list) {
        data.addAll(list);
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private LayoutCelebrityItemBinding binding;

        public MyViewHolder(@NonNull View itemView, LayoutCelebrityItemBinding binding) {
            super(itemView);
            this.binding = binding;
        }
    }
}
