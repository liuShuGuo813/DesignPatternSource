package com.example.shuguo.designpatternsource.factory.simple

/**
 *  @Time : 2021-12-17
 *  @Author : lsg
 *  @Description : 加法运算
 */
class OperationAdd : Operation(){

    override fun getResult(): Int {
        return numA + numB
    }

}