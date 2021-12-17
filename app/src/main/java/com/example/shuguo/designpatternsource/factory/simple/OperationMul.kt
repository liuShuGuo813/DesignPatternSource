package com.example.shuguo.designpatternsource.factory.simple

/**
 *  @Time : 2021-12-17
 *  @Author : lsg
 *  @Description : 乘法运算
 */
class OperationMul : Operation(){

    override fun getResult(): Int {
        return numA * numB
    }

}