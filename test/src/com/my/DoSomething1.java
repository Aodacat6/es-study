package com.my;

/**
 * @author ：songdalin
 * @date ：2022/11/17 下午 6:28
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class DoSomething1 extends DoSomething {


    @Override
    public void callback(String s) {
        System.out.println("1 get " + s);
    }
}
