package com.example.databindingdemo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewStub

import com.example.databindingdemo.adapter.NewsAdapter
import com.example.databindingdemo.bean.NewsInfo
import com.example.databindingdemo.databinding.ActivityBindingBinding
import com.example.databindingdemo.databinding.LayoutBarBinding

import java.util.ArrayList

/**
 * @author yanglijun
 * @date 19-2-25
 */
class BindingClassActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBindingBinding
    private lateinit var adapter: NewsAdapter

    private val news: List<NewsInfo>
        get() {
            val news = ArrayList<NewsInfo>()
            val randy = NewsInfo()
            randy.newsType = 2
            randy.content = "扎克·莱德(Zack Ryder)看到这条动态后，下方留言道“恭喜你！兄弟，他们从未找我拍2K游戏广告！”兰迪·奥顿看到这条评论后，特意回复了扎克·莱德！\n" +
                    "兰迪·奥顿:" +
                    "“那是他们的损失！是金子注定会发光，我相信某人注定会赏识你的能力！你一直都是精英选手！”" +
                    "面对兰迪·奥顿突然的暖心鼓励，有网友在这条更新下评论称，毒蛇啥时候成暖男了？"
            randy.title = "WWE兰迪盛赞扎克·莱德是精英！网友：毒蛇变暖男了？"
            randy.image = R.drawable.news1
            news.add(randy)

            val roman = NewsInfo()
            roman.newsType = 2
            roman.content = "摔角网讯，上周四，WWE主席文斯·麦克曼(Vince McMahon)突然宣布WWE巨星罗曼·雷恩斯(Roman Reigns)将回归下周RAW节目！随即门票收入便实现了跃升！WWE高层原本可以将这一消息等到今天再宣布，不过公司率先公布，就是为了提升本周RAW节目的收视率以及门票收入情况！\n" + "此前周一RAW最低门票已来到了17美元一张，而明日RAW的门票最低票价也是34美元，并且WWE官方显示，门票价格会因为供求关系而产生波动，这意味着如果门票依然畅销的话，最低门票价格还会上涨！这点足以说明罗曼·雷恩斯的吸金力！"
            roman.title = "WWE罗曼·雷恩斯吸金力十足，周赛票价就是最佳例证！"
            roman.image = R.drawable.news2
            news.add(roman)

            val dave = NewsInfo()
            dave.newsType = 1
            dave.content = "摔角网讯，北京时间2019年2月25日，WWE剧情组人员发生了举动变动，WWE主席文斯·麦克曼(Vince McMahon)重新雇佣了布鲁斯·普里查德，并让其担任WWE剧情组一把手，可见文斯对其的信任！\n" +
                    "此外，就在刚刚，WWE再度签下了一位前WWE剧情写手Dave Schilling，而他将在下个月正式投入剧情创作工作！Dave曾受聘于ESPN，也曾参与到电影《惊涛大冒险》的创作！\n" +
                    "看来文斯·麦克曼已开始从根源着手解决收视率下滑的问题，未来WWE收视率有望上扬！"
            dave.title = "WWE老麦终于出手了。剧情组迎来两位新巨头！"
            dave.image = 0
            news.add(dave)

            val dean = NewsInfo()
            dean.newsType = 1
            dean.content = "此前，据媒体人戴夫·梅尔泽表示，在这场比赛中，迪安·安布罗斯(Dean Ambrose)吃了德鲁一记Claymore Kick！而后裁判立马对后台做出了一个X的手式！\n" +
                    "众所周知，在WWE节目中出现X的手式，就意味着选手是真的受伤了！目前还不清楚迪安的伤病情况。\n" +
                    "就在刚刚！RSN放出消息称，戴夫·梅尔泽的消息出现失误，真正受伤的人并非迪安·安布罗斯，而是德鲁·麦金泰尔！剧情突然翻转，小编都跟着蒙圈！RSN爆料，到了赛后，德鲁·麦金泰尔是在裁判的搀扶下，走向后台，据最新消息，德鲁的伤情已无大碍，只是虚惊一场！"
            dean.title = "剧情突然反转！WWE现场秀上受伤的另有其人！"
            dean.image = 0
            news.add(dean)
            return news
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding)
        binding.vsBar.setOnInflateListener { _, inflated ->
            val vsBarBinding = DataBindingUtil.bind<LayoutBarBinding>(inflated)
            vsBarBinding?.name = "木易"
            vsBarBinding?.resId = R.drawable.head
        }
        binding.activity = this

        adapter = NewsAdapter()
        binding.adapter = adapter
        adapter.setData(news)
    }

    fun showViewStub() {
        val viewStub = binding.vsBar.viewStub
        viewStub?.inflate()
    }
}
