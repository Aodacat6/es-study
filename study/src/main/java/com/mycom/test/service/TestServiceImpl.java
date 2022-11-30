package com.mycom.test.service;


import com.mycom.test.esrepository.OrderInfoRepository;
import com.mycom.test.pojo.OrderInfo;
import com.mycom.test.util.EasyExcelUtils;
import com.mycom.test.util.ExcelListener;
import org.apache.lucene.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author ：songdalin
 * @date ：2022/11/7 下午 3:39
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Service
public class TestServiceImpl {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

/*    public void createIndex() throws FileNotFoundException {
        //从数据库拿到数据集
        //final List<User> data = UserDataSet.getData();
        //定义数据结构
        //InputStream in = new FileInputStream("C:\\Users\\22023964\\order_info_202211171635.csv");
        //EasyExcelUtils.readExcel(in, new OrderInfo(), new ExcelListener());

    }*/

    public static void main(String[] args) throws FileNotFoundException {
        //定义数据结构
        //InputStream in = new FileInputStream("C:\\Users\\22023964\\order_info_202211171635.csv");
        final ExcelListener excelListener = new ExcelListener();
        EasyExcelUtils.readExcel("C:\\Users\\22023964\\order_info_202211171635.csv", new OrderInfo(), excelListener);
        final List<Object> datas = excelListener.getDatas();
        System.out.println(datas.size());

        EasyExcelUtils.writeExcel(datas, "C:\\Users\\22023964\\order_info_write_out.csv");
    }

    /**
     * 创建索引
     */
    public void createOrderInfoIndex() {
        final IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(OrderInfo.class);
        indexOperations.createMapping(OrderInfo.class);
        final boolean re = indexOperations.create();
        if (re) {
            System.out.println("===========创建成功");
        } else {
            System.out.println("===========创建失败");
        }
    }

    /**
     * 批量同步索引
     */
    public void syncData() {
        final ExcelListener excelListener = new ExcelListener();
        EasyExcelUtils.readExcel("C:\\Users\\22023964\\order_info_202211171635.csv", new OrderInfo(), excelListener);
        final List<Object> datas = excelListener.getDatas();
        List<OrderInfo> list = new ArrayList<>();
        for (Object data : datas) {
            list.add((OrderInfo) data);
        }
        orderInfoRepository.saveAll(list);
        System.out.println("==============同步保存完成");
    }

    /**
     * 删除文档
     */
    public void deleteDoc() {
        orderInfoRepository.deleteAll();
        System.out.println("=========删除全部结束");
    }

    public void qryById() {
        String orderId = "GSPI202204289417";
        final Optional<OrderInfo> optional = orderInfoRepository.findById(orderId);
        if (optional.isPresent()) {
            System.out.println(optional.get());
            return;
        }
        System.out.println("===============没有数据");
    }

    public void myQry() {
        String custManager = "01429583xx";
        final List<OrderInfo> list = orderInfoRepository.findOrderInfoByCustManager(custManager);
        if (CollectionUtils.isEmpty(list)){
            System.out.println("==========空的，不存在");
            return;
        }
        list.forEach(System.out::println);
    }

    /**
     *
     * 超过10000的深度分页，推荐采用search_after + PIT。
     *
     *
     *
     */
    public void findTextField() {
        //text字段查询
        String depCodeName = "小V";
        final Pageable pageable = PageRequest.of(10, 1000, Sort.unsorted());
        final Page<OrderInfo> page = orderInfoRepository.findOrderInfoByDeptCodeName(depCodeName, pageable);
        if (page.isEmpty()){
            System.out.println("==========空的，不存在");
            return;
        }
        for (OrderInfo orderInfo : page.getContent()) {
            System.out.println(orderInfo);
        }
    }

    /**
     * 统计
     */
    public void countDoc() {
        System.out.println("======" + orderInfoRepository.count());
    }

    /**
     * 看看是否会报最大10000条的错
     *          一样会报错
     */
    public void getAllNotPage() {
        final Iterable<OrderInfo> all = orderInfoRepository.findAll();
        for (OrderInfo orderInfo : all) {
            System.out.println(orderInfo);
        }
    }

}
