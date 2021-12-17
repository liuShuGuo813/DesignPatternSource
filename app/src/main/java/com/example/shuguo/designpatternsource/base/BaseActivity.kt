package com.example.shuguo.designpatternsource.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.shuguo.designpatternsource.util.ParamUtil

/**
 *  @Time : 2021-12-17
 *  @Author : lsg
 *  @Description : Activity基类
 */
abstract class BaseActivity<VDB : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var bindView: VDB
    protected val mClassName = javaClass.simpleName
    protected lateinit var activity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this
        bindView = DataBindingUtil.setContentView(this, getLayoutId())
        ParamUtil.initParam(this)
        setListener()
    }

    /**
     * 处理页面监听事件
     */
    protected open fun setListener() {}

    abstract fun getLayoutId(): Int

    open fun startActivity(bundle: Bundle = Bundle(), clazz: Class<*>) {
        val intent = Intent(this, clazz)
        intent.putExtras(bundle)
        this.startActivity(intent)
    }

}