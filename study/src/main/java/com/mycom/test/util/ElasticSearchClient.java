/*
package com.mycom.test.util;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

*/
/**
 * @author ：songdalin
 * @date ：2022/11/16 下午 6:28
 * @description：
 * @modified By：
 * @version: 1.0
 *//*

@Slf4j
@Component
public class ElasticSearchClient {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    */
/**
     * 检查索引是否存在
     * @param indexName
     * @return
     *//*

    public boolean existsIndex(String indexName){
        try {
            // 创建请求
            GetIndexRequest request = new GetIndexRequest().indices(indexName);
            // 执行请求,获取响应
            boolean response = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
            return response;
        } catch (Exception e) {
            log.error("向es发起查询索引是否存在请求失败，请求参数：" + indexName, e);
        }
        return false;
    }
}
*/
