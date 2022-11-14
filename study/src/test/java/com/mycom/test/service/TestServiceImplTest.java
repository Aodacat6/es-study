package com.mycom.test.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycom.test.pojo.User;
import lombok.SneakyThrows;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ：songdalin
 * @date ：2022/11/7 下午 5:07
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceImplTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 创建索引
     * @throws IOException
     */
    @Test
    public void createIndex() throws IOException {
        //创建索引库参数
        CreateIndexRequest indexRequest = new CreateIndexRequest("my_first_idnex");
        indexRequest.settings(Settings.builder()
                //分片数
                .put("index.number_of_shards", 1)
                //副本数
                .put("index.number_of_replicas", 1));
        //创建索引操作客户端
        final IndicesClient indices = restHighLevelClient.indices();
        //客户端创建索引
        final CreateIndexResponse createIndexResponse = indices.create(indexRequest, RequestOptions.DEFAULT);
        //获取响应结果
        final boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("index 创建结果：" + acknowledged);
    }

    /**
     * 查询索引
     */
    @Test
    @SneakyThrows
    public void queryIndex() {
        final GetIndexRequest getIndexRequest = new GetIndexRequest();
        getIndexRequest.indices("my_first_idnex");
        final GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println("返回：" + getIndexResponse);
        System.out.println("索引 mapping：" + getIndexResponse.getMappings());
    }

    /**
     * 删除索引
     */
    @Test
    @SneakyThrows
    public void deleteIndex() {
        //定义删除请求
        final DeleteIndexRequest my_first_idnex = new DeleteIndexRequest("my_first_idnex");
        //执行删除操作，拿到操作结果
        final AcknowledgedResponse delete = restHighLevelClient.indices().delete(my_first_idnex, RequestOptions.DEFAULT);
        System.out.println("删除结果：" + delete.isAcknowledged());
    }

    /**
     * 添加文档
     */
    @Test
    public void addDoc() throws IOException {
        User user = new User("小兔", 12, "我是小兔，和嗷大喵是朋友");
        final IndexRequest request = new IndexRequest("my_first_idnex");
        request.id("2");
        request.source(objectMapper.writeValueAsString(user), XContentType.JSON);
        final IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response);
        System.out.println(response.status());
    }

    /**
     * 查询文档是否存在
     * @throws IOException
     */
    @Test
    public void existsDoc() throws IOException {
        final GetRequest request = new GetRequest("my_first_idnex", "2");
        final boolean exists = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     *     获取文档信息
     */
    @Test
    public void getDoc() throws IOException {
        final GetRequest request = new GetRequest("my_first_idnex", "2");
        final GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSource());
    }

    /**
     * 更新文档
     */
    @Test
    public void updateDoc() throws IOException {
        //UpdateRequest request = new UpdateRequest("my_first_idnex", "1");
        //这两处都设置了id，后面的为准
        UpdateRequest request = new UpdateRequest("my_first_idnex", "1");
        request.id("2");
        User dam = new User("大喵1号", 99, "更新后的信息");
        request.doc(objectMapper.writeValueAsString(dam), XContentType.JSON);
        final UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        System.out.println(response);

    }

    /**
     * 删除文档
     * @throws IOException
     */
    @Test
    public void deleteDoc() throws IOException {
        final DeleteRequest deleteRequest = new DeleteRequest("my_first_idnex");
        deleteRequest.id("2");
        final DeleteResponse response = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    /**
     * 批量插入
     */
    @Test
    public void batchAdd() throws IOException {
        List<User> list = new ArrayList<>();
        User user = new User("张三", 1, "这里是张三");
        User user2 = new User("李四", 1, "李四");
        User user3 = new User("李四1", 1, "李四");
        User user4 = new User("李四2", 1, "李四");
        User user5 = new User("李四3", 1, "李四");
        User user6 = new User("李四4", 1, "张三");
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);
        list.add(user);
        final BulkRequest bulkRequest = new BulkRequest();
        for (User tusr : list) {
            bulkRequest.add(new IndexRequest("my_first_idnex")
                            //.id("")  不指定id，随机id
                    .source(objectMapper.writeValueAsString(tusr), XContentType.JSON));
        }
        final BulkResponse response = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(response.status());

    }
    /**
     * 查询
     */
    @Test
    public void search() throws IOException {
        SearchRequest searchRequest = new SearchRequest("my_first_idnex");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //精准查找
        //term query会去倒排索弓|中寻找确切的term,它并不知道分词器的存在,所以如下查询，“name”会查不到
        final TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name.keyword", "李四1");
        sourceBuilder.query(termQueryBuilder);
        //查询全部
        //sourceBuilder.query();
        searchRequest.source(sourceBuilder);
        final SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(searchResponse);
        System.out.println(searchResponse.getHits());
        System.out.println("---------------------------------------");
        for (SearchHit hit : searchResponse.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }


}

