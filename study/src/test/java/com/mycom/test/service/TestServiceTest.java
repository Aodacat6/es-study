package com.mycom.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author ：songdalin
 * @date ：2022/11/18 下午 2:06
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest {

    @Autowired
    private TestServiceImpl testService;

    @Test
    public void createOrderInfoIndex() {
        testService.createOrderInfoIndex();
    }

    @Test
    public void syncData() {
        testService.syncData();
    }

    @Test
    public void deleteAll() {
        testService.deleteDoc();
    }

    @Test
    public void qryById() {
        testService.qryById();
    }

    @Test
    public void myQry() {
        testService.myQry();
    }

    @Test
    public void findText() {
        testService.findTextField();
    }










}