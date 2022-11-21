package com.mycom.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author ：songdalin
 * @date ：2022/11/21 下午 3:40
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
public class CircleDependTest {

    //方法二，set方法
    // 注：  springboot 默认是关闭解决循环依赖的，需要通过配置打开
    //                         spring:
    //                            main:
    //                                allow-circular-references: true
    //
    //

    @Autowired
    public void setCircleDependTest2(CircleDependTest2 circleDependTest2) {
        this.circleDependTest2 = circleDependTest2;
    }

    public CircleDependTest2 getCircleDependTest2() {
        return circleDependTest2;
    }

    //方法一
    //@Lazy
    //@Autowired
    private CircleDependTest2 circleDependTest2;
}
