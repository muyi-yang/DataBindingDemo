package com.example.databindingdemo

import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View

import com.example.databindingdemo.adapter.ListAdapter
import com.example.databindingdemo.bean.CelebrityInfo
import com.example.databindingdemo.databinding.ActivityListBinding

/**
 * @author yanglijun
 * @date 19-2-18
 */
class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var adapter: ListAdapter

    val listData = ObservableArrayList<CelebrityInfo>()

    val name = ObservableField<String>()
    val index = ObservableInt()

    var scrollListener: RecyclerView.OnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            Log.d("ListActivity", "onScrollStateChanged newState:$newState")
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            Log.d("ListActivity", "onScrolled dx:$dx,dy:$dy")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)

        binding.activity = this

        adapter = ListAdapter()
        binding.adapter = adapter

        adapter.setData(listData)
        adapter.setItemClickListener(object : ListAdapter.MyItemClickListener {
            override fun onItemClick(v: View, position: Int, info: CelebrityInfo) {
                name.set(info.name)
                index.set(position)
            }
        })

        getCelebrityList()
    }

    private fun getCelebrityList() {
        Handler().postDelayed({
            val brock = CelebrityInfo()
            brock.name = "布洛克·莱斯纳"
            brock.weight = 130
            brock.isRetire = false
            brock.income = 1000.0
            brock.photo = R.drawable.brock
            listData.add(1, brock)
        }, 2000)

        val dwayne = CelebrityInfo()
        dwayne.name = "巨石·强森"
        dwayne.weight = 115
        dwayne.isRetire = true
        dwayne.income = 2000.0
        dwayne.photo = R.drawable.dwayne
        listData.add(dwayne)

        val john = CelebrityInfo()
        john.name = "约翰·塞纳"
        john.weight = 114
        john.isRetire = true
        john.income = 1000.0
        john.photo = R.drawable.john
        listData.add(john)

        val randy = CelebrityInfo()
        randy.name = "兰迪·奥顿"
        randy.weight = 111
        randy.isRetire = false
        randy.income = 999.0
        randy.photo = R.drawable.randy
        listData.add(randy)

        val roman = CelebrityInfo()
        roman.name = "罗曼·雷恩斯"
        roman.weight = 120
        roman.isRetire = false
        roman.income = 800.0
        roman.photo = R.drawable.roman
        listData.add(roman)
    }
}
