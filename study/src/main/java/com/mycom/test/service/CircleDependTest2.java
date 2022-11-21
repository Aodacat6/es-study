package com.mycom.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：songdalin
 * @date ：2022/11/21 下午 3:40
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
public class CircleDependTest2 {

    @Autowired
    public void setCircleDependTest3(CircleDependTest3 circleDependTest3) {
        this.circleDependTest3 = circleDependTest3;
    }

    public CircleDependTest3 getCircleDependTest3() {
        return circleDependTest3;
    }

    //@Autowired
    private CircleDependTest3 circleDependTest3;
}
