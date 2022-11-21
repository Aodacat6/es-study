package com.mycom.test.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：songdalin
 * @date ：2022/11/17 下午 4:55
 * @description：   easyexcel 监听器
 * @modified By：
 * @version: 1.0
 */
public class ExcelListener extends AnalysisEventListener<Object> {

    /**
     * 存储读取到的数据
     */
    private List<Object> datas = new ArrayList<>();

    /**
     * 解析数据进入的方法
     * @param data
     * @param context
     */
    @Override
    public void invoke(Object data, AnalysisContext context) {
        datas.add(data);
        System.out.println("读取到数据:" + data);
    }

    /**
     * 所有数据解析完成，回来调用
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("excel解析完成");
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        if (exception instanceof ExcelDataConvertException) {
            System.out.println("第 " + ((ExcelDataConvertException) exception).getRowIndex() +"行, "
                    + ((ExcelDataConvertException) exception).getColumnIndex() +"列 发生错误"
                    + "， 错误数据为：" + ((ExcelDataConvertException) exception).getCellData().getStringValue());
        }
        throw exception;
    }

    public List<Object> getDatas() {
        return this.datas;
    }
}
