package com.example.shuguo.designpatternsource.factory.simple

/**
 *  @Time : 2021-12-17
 *  @Author : lsg
 *  @Description : 运算-简单工厂实现
 */
class OperationFactory {

    companion object {
        fun createOperate(operate: String): Operation? {
            var operation: Operation? = null
            when (operate) {
                "+" -> operation = OperationAdd()
                "-" -> operation = OperationSub()
                "*" -> operation = OperationMul()
                "/" -> operation = OperationDiv()
            }
            return operation
        }
    }

}