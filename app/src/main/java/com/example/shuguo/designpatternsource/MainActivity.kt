package com.example.shuguo.designpatternsource

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.drake.brv.utils.grid
import com.drake.brv.utils.setup
import com.example.shuguo.designpatternsource.base.BaseActivity
import com.example.shuguo.designpatternsource.common.toast
import com.example.shuguo.designpatternsource.databinding.ActivityMainBinding
import com.example.shuguo.designpatternsource.factory.FactoryActivity
import com.example.shuguo.designpatternsource.model.PatternModel

/**
 * @Time : 2021-12-17
 * @Author : lsg
 * @Description : 设计模式示例页面
 **/
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val patterns = arrayOf(
        "观察者模式", "工厂模式",
        "单例设计模式", "策略模式",
        "适配器模式", "命令模式",
        "装饰者模式", "外观模式",
        "模板方法模式", "状态模式",
        "建造者模式", "原型模式",
        "享元模式", "代理模式",
        "桥接模式", "组合模式",
        "迭代器模式", "中介者模式",
        "备忘录模式", "解释器模式",
        "责任链模式", "访问者模式"
    )

    private val classes = arrayOf(
        FactoryActivity::class.java, FactoryActivity::class.java,
        FactoryActivity::class.java, FactoryActivity::class.java,
        FactoryActivity::class.java, FactoryActivity::class.java,
        FactoryActivity::class.java, FactoryActivity::class.java,
        FactoryActivity::class.java, FactoryActivity::class.java,
        FactoryActivity::class.java, FactoryActivity::class.java,
        FactoryActivity::class.java, FactoryActivity::class.java,
        FactoryActivity::class.java, FactoryActivity::class.java,
        FactoryActivity::class.java, FactoryActivity::class.java,
        FactoryActivity::class.java, FactoryActivity::class.java,
        FactoryActivity::class.java, FactoryActivity::class.java
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        title = "设计模式示例"
        bindView.rcvPattern.grid(spanCount = 2).setup {
            addType<PatternModel>(R.layout.item_pattern)
            onClick(R.id.btn_pattern){
                val bundle = Bundle()
                bundle.putString("title",getModel<PatternModel>().name)
                startActivity(bundle = bundle,clazz = classes[modelPosition])
            }
        }.models = getData()
    }

    private fun getData(): List<PatternModel?>? {
        var patternModelList = ArrayList<PatternModel>()
        patterns.forEach {
            patternModelList.add(PatternModel(it))
        }
        return patternModelList
    }

    override fun getLayoutId() = R.layout.activity_main
}