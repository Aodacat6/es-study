package com.my;

/**
 * @author ：songdalin
 * @date ：2022/11/17 下午 6:28
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class DoSomething2 extends DoSomething {

    @Override
    public void callback(String s) {
        System.out.println("2 get " + s);
    }
}
