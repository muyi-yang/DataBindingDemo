package com.example.databindingdemo.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.databindingdemo.BR
import com.example.databindingdemo.bean.NewsInfo
import com.example.databindingdemo.databinding.LayoutNewsItemPictureBinding
import com.example.databindingdemo.databinding.LayoutNewsItemTextBinding
import java.util.*

/**
 * @author yanglijun
 * @date 19-2-25
 */
class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val data = ArrayList<NewsInfo>()

    private val VIEW_TYPE_TEXT = 1
    private val VIEW_TYPE_PICTURE = 2

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding: ViewDataBinding
        if (viewType == VIEW_TYPE_TEXT) {
            binding = LayoutNewsItemTextBinding.inflate(inflater, viewGroup, false)
        } else {
            binding = LayoutNewsItemPictureBinding.inflate(inflater, viewGroup, false)
        }
        return NewsViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(viewHolder: NewsViewHolder, position: Int) {
        val binding = viewHolder.binding
        binding.setVariable(BR.info, data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(list: List<NewsInfo>) {
        data.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].newsType
    }

    class NewsViewHolder(itemView: View, val binding: ViewDataBinding) : RecyclerView.ViewHolder(itemView)
}
