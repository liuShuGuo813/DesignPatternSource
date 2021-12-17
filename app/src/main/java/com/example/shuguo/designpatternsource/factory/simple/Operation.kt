package com.example.shuguo.designpatternsource.factory.simple

/**
 *  @Time : 2021-12-17
 *  @Author : lsg
 *  @Description : 运算基类
 */
open class Operation {

    var numA: Int = 0
    var numB: Int = 0

    open fun getResult(): Int {
        var result = 0
        return result
    }

}