package com.mycom.test.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.util.List;

/**
 * @author ：songdalin
 * @date ：2022/11/17 下午 6:13
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class EasyExcelUtils {

    /**
     * 读取excel
     * @param filePath  excel 文件地址
     * @param object   与文件对应的实体
     * @param excelListener  通用读取数据解析监听器
     * @return
     */
    public static List<Object> readExcel(String filePath , Object object, ExcelListener excelListener) {
        final ExcelReader reader = EasyExcel.read(filePath, object.getClass(), excelListener).build();
        try {
            reader.readAll();
        }finally {
            reader.finish();
        }
        final List<Object> data = excelListener.getDatas();
        return data;
    }

    /**
     * 保存excel
     * @param datas   待写入数据
     * @param savePath  保存路径
     * @return
     */
    public static <T> boolean writeExcel(List<T> datas, String savePath) {
        final ExcelWriter excelWriter = EasyExcel.write(savePath).build();
        try {
            WriteSheet writeSheet = EasyExcel.writerSheet(1, "第一页").head(datas.get(0).getClass()).build();
            excelWriter.write(datas, writeSheet);
        } finally {
            excelWriter.finish();
        }
        return true;
    }


}
