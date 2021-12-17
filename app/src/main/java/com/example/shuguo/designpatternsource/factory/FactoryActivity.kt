package com.example.shuguo.designpatternsource.factory

import android.os.Bundle
import android.widget.Toast
import com.drake.brv.utils.linear
import com.drake.brv.utils.setup
import com.example.shuguo.designpatternsource.R
import com.example.shuguo.designpatternsource.base.BaseActivity
import com.example.shuguo.designpatternsource.common.toast
import com.example.shuguo.designpatternsource.databinding.ActivityFactoryBinding
import com.example.shuguo.designpatternsource.factory.simple.OperationFactory
import com.example.shuguo.designpatternsource.model.PatternModel
import com.example.shuguo.designpatternsource.util.Param
import logE

/**
 * @Time : 2021-12-17
 * @Author : lsg
 * @Description : 工厂模式示例页面
 **/
class FactoryActivity : BaseActivity<ActivityFactoryBinding>() {

    private val patterns = arrayOf(
        "静态工厂模式", "简单工厂模式",
        "工厂模式", "抽象工厂模式"
    )

    private val STATIC_FACTORY = 0
    private val SIMPLE_FACTORY = 1
    private val FACTORY = 2
    private val ABSTRACT_FACTORY = 3

    @Param
    private val title: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        setTitle(title)
        bindView.rcvPattern.linear().setup {
            addType<PatternModel>(R.layout.item_pattern)
            onClick(R.id.btn_pattern){
                when(modelPosition){
                    STATIC_FACTORY -> {
                        //静态工厂模式
                        Toast.makeText(activity, "TextUtil.isEmpty等，类+静态方法.",
                            Toast.LENGTH_SHORT).show()
                    }
                    SIMPLE_FACTORY -> {
                        //简单工厂模式
                        val createOperate = OperationFactory.createOperate("+")
                        try {
                            createOperate?.let {
                                it.numA = 1
                                it.numB = 3
                                it.getResult().logE()
                                toast(
                                    "运算参数A为：${it.numA}\n" +
                                            "运算参数B为：${it.numB}\n" +
                                            "结果为：${it.getResult()}"
                                )
                            }
                        } catch (e: Exception) {
                            e.toString().logE()
                        }
                    }
                    FACTORY -> {
                        //工厂方法模式

                    }
                    ABSTRACT_FACTORY -> {
                        //抽象工厂模式

                    }
                }
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

    override fun setListener() {

    }

    override fun getLayoutId() = R.layout.activity_factory
}