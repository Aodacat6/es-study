package com.mycom.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：songdalin
 * @date ：2022/11/9 下午 4:44
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String desc;
}
