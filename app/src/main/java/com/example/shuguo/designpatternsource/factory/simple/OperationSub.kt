package com.example.shuguo.designpatternsource.factory.simple

/**
 *  @Time : 2021-12-17
 *  @Author : lsg
 *  @Description : 减法运算
 */
class OperationSub : Operation(){

    override fun getResult(): Int {
        return numA - numB
    }

}