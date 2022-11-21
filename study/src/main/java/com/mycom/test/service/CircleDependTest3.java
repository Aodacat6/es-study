package com.mycom.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：songdalin
 * @date ：2022/11/21 下午 4:05
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
public class CircleDependTest3 {

    public CircleDependTest getCircleDependTest() {
        return circleDependTest;
    }

    @Autowired
    public void setCircleDependTest(CircleDependTest circleDependTest) {
        this.circleDependTest = circleDependTest;
    }

    private CircleDependTest circleDependTest;
}
