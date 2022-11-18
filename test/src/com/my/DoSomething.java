package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：songdalin
 * @date ：2022/11/17 下午 6:24
 * @description：
 * @modified By：
 * @version: 1.0
 */
public abstract class DoSomething {

    private SomethingContent somethingContent = new SomethingContent();

    public DoSomething() {
        somethingContent.list.add(this);
    }

    public abstract void callback(String s) ;

    public void sendData(String data) {
        for (DoSomething doSomething : somethingContent.list) {
            doSomething.callback(data);
        }
    }
}
