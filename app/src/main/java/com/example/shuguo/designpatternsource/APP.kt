package com.example.shuguo.designpatternsource

import android.app.Application
import com.drake.brv.utils.BRV

/**
 *  @Time : 2021-12-17
 *  @Author : lsg
 *  @Description : 项目入口类
 */
class APP : Application(){

    override fun onCreate() {
        super.onCreate()
        // 初始化BindingAdapter的默认绑定ID, 如果不使用DataBinding并不需要初始化
        BRV.modelId = BR.m
    }

}