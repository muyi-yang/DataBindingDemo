package com.example.databindingdemo.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.databindingdemo.BR;
import com.example.databindingdemo.bean.NewsInfo;
import com.example.databindingdemo.databinding.LayoutNewsItemPictureBinding;
import com.example.databindingdemo.databinding.LayoutNewsItemTextBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanglijun
 * @date 19-2-25
 */
public class NewsAdapter extends RecyclerView.Adapter {

    private List<NewsInfo> data = new ArrayList<>();

    private final int VIEW_TYPE_TEXT = 1;
    private final int VIEW_TYPE_PICTURE = 2;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding binding;
        if (viewType == VIEW_TYPE_TEXT) {
            binding = LayoutNewsItemTextBinding.inflate(inflater, viewGroup, false);
        } else {
            binding = LayoutNewsItemPictureBinding.inflate(inflater, viewGroup, false);
        }
        return new NewsViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        NewsViewHolder holder = (NewsViewHolder) viewHolder;
        ViewDataBinding binding = holder.binding;
        binding.setVariable(BR.info, data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<NewsInfo> list) {
        data.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).newsType;
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public NewsViewHolder(@NonNull View itemView, ViewDataBinding binding) {
            super(itemView);
            this.binding = binding;
        }
    }
}
