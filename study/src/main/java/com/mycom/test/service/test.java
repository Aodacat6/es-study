package com.mycom.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：songdalin
 * @date ：2022/11/21 下午 3:25
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Component
public class test {

    public test(TestServiceImpl testService) {
        this.testService = testService;
    }

    private TestServiceImpl testService;



    public void ddd() {
        testService.qryById();
    }
}
