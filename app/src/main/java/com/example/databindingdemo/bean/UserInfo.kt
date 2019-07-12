package com.example.databindingdemo.bean

import java.util.ArrayList
import java.util.HashMap

/**
 * @author yanglijun
 * @date 19-2-16
 */
class UserInfo {
    var name: String? = null
    var age: Int = 0
    var sex: Int = 0
    var sign: String? = null
    var avatarId: Int = 0

    var tripMode = arrayOf("公交车", "地铁", "开车")
    var colleague: MutableList<String> = ArrayList()
    var task: MutableMap<String, String> = HashMap()

    init {
        colleague.add("张三")
        colleague.add("李四")
        colleague.add("王五")

        task["monday"] = "整理思路及确定整体框架"
        task["tuesday"] = "开始进行编写"
        task["wednesday"] = "检测及修订"
    }
}
