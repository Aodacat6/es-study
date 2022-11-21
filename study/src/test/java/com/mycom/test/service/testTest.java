package com.mycom.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author ：songdalin
 * @date ：2022/11/21 下午 3:26
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class testTest {

    @Autowired
    private test test;

    @Test
    public void ddd() {
        test.ddd();

    }
}