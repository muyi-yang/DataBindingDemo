package com.example.databindingdemo.adapter

import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.databindingdemo.bean.CelebrityInfo
import com.example.databindingdemo.databinding.LayoutCelebrityItemBinding

/**
 * @author yanglijun
 * @date 19-2-22
 */
class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var data: ObservableArrayList<CelebrityInfo>? = null
    private var itemClickListener: MyItemClickListener? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = LayoutCelebrityItemBinding
                .inflate(inflater, viewGroup, false)
        return MyViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, i: Int) {
        viewHolder.setItemClickListener(itemClickListener)
        viewHolder.binding.info = data!![i]
    }

    override fun getItemCount(): Int {
        return if (data == null) 0 else data!!.size
    }

    fun setData(list: ObservableArrayList<CelebrityInfo>) {
        data = list
        if (data != null) {
            data!!.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableList<CelebrityInfo>>() {
                override fun onChanged(sender: ObservableList<CelebrityInfo>) {
                    notifyDataSetChanged()
                }

                override fun onItemRangeChanged(sender: ObservableList<CelebrityInfo>, positionStart: Int, itemCount: Int) {
                    notifyItemRangeChanged(positionStart, itemCount)
                }

                override fun onItemRangeInserted(sender: ObservableList<CelebrityInfo>, positionStart: Int, itemCount: Int) {
                    notifyItemRangeInserted(positionStart, itemCount)
                }

                override fun onItemRangeMoved(sender: ObservableList<CelebrityInfo>, fromPosition: Int, toPosition: Int, itemCount: Int) {
                    notifyItemMoved(fromPosition, toPosition)
                }

                override fun onItemRangeRemoved(sender: ObservableList<CelebrityInfo>, positionStart: Int, itemCount: Int) {
                    notifyItemRangeRemoved(positionStart, itemCount)
                }
            })
        }
    }

    fun setItemClickListener(listener: MyItemClickListener) {
        itemClickListener = listener
    }

    inner class MyViewHolder(itemView: View, val binding: LayoutCelebrityItemBinding) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var itemClickListener: MyItemClickListener? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun setItemClickListener(listener: MyItemClickListener?) {
            itemClickListener = listener
        }

        override fun onClick(v: View) {
            val position = layoutPosition
            itemClickListener!!.onItemClick(v, position, data!![position])
        }
    }

    interface MyItemClickListener {
        fun onItemClick(v: View, position: Int, info: CelebrityInfo)
    }
}
