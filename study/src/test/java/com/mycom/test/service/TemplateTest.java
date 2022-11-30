package com.mycom.test.service;

import com.mycom.test.pojo.OrderInfo;
import org.apache.poi.ss.formula.functions.T;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchScrollHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：songdalin
 * @date ：2022/11/30 下午 1:48
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateTest {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;


    /**
     * scroll 解决深度分页
     */
    @Test
    public void testTemplate() {
        List<OrderInfo> orderInfos = new ArrayList<>();
        long scrollTimeInMillis = 10000;
        //MatchQueryBuilder queryBuilders = QueryBuilders.matchQuery("poNo", "MAM210907024SDWM");
        MatchQueryBuilder queryBuilders = QueryBuilders.matchQuery("saleOrgName", "6110");
        Query query = new NativeSearchQueryBuilder().withQuery(queryBuilders).build();
        query.setPageable(PageRequest.of(0, 10000));
        Class<OrderInfo> clazz = OrderInfo.class;
        IndexCoordinates index = IndexCoordinates.of("order_info_index");
        final SearchScrollHits<OrderInfo> searchHits = elasticsearchRestTemplate.searchScrollStart(scrollTimeInMillis, query, clazz, index);

        SearchHits<OrderInfo> searchHits1 = elasticsearchRestTemplate.search(query, clazz, index);
        while (searchHits1.hasSearchHits()) {
            final List<OrderInfo> list = searchHits1.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
            orderInfos.addAll(list);
            searchHits1 = elasticsearchRestTemplate.searchScrollContinue(searchHits.getScrollId(), scrollTimeInMillis, clazz, index);
        }
        System.out.println("===========总数：" + orderInfos.size());

    }

}
