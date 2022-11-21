package com.mycom.test.esrepository;

import com.mycom.test.pojo.OrderInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：songdalin
 * @date ：2022/11/18 下午 1:58
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Repository
public interface OrderInfoRepository extends ElasticsearchRepository<OrderInfo, String> {

    List<OrderInfo> findOrderInfoByCustManager(String custManager);

    Page<OrderInfo> findOrderInfoByDeptCodeName(String deptCodeName, Pageable page);
}
