/*
package com.mycom.test.controller;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;

*/
/**
 * @author ：songdalin
 * @date ：2022/11/7 下午 3:16
 * @description：
 * @modified By：
 * @version: 1.0
 *//*

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public void createIndex() {

    }


    public static void main(String[] args){
*/
/*        final DecimalFormat df = new DecimalFormat("#.00");
        final String format = df.format(Double.valueOf("3"));
        double parseDouble = Double.valueOf(format);
        System.out.println(parseDouble);*//*


        final BigDecimal bigDecimal = new BigDecimal("3").setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal.doubleValue());
    }

}
*/
