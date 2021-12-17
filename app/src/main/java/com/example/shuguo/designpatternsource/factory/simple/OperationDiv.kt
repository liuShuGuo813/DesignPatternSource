package com.example.shuguo.designpatternsource.factory.simple

import java.lang.Exception

/**
 *  @Time : 2021-12-17
 *  @Author : lsg
 *  @Description : 除法运算
 */
class OperationDiv : Operation(){

    override fun getResult(): Int {
        if(numB == 0){
            throw Exception("除数不能为0")
        }
        return numA / numB
    }

}