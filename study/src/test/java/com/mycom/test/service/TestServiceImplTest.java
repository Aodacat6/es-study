/*
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

*/
/**
 * @author ???songdalin
 * @date ???2022/11/7 ?????? 5:07
 * @description???
 * @modified By???
 * @version: 1.0
 *//*

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceImplTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    private ObjectMapper objectMapper = new ObjectMapper();

    */
/**
     * ????????????
     * @throws IOException
     *//*

    @Test
    public void createIndex() throws IOException {
        //?????????????????????
        CreateIndexRequest indexRequest = new CreateIndexRequest("my_first_idnex");
        indexRequest.settings(Settings.builder()
                //?????????
                .put("index.number_of_shards", 1)
                //?????????
                .put("index.number_of_replicas", 1));
        //???????????????????????????
        final IndicesClient indices = restHighLevelClient.indices();
        //?????????????????????
        final CreateIndexResponse createIndexResponse = indices.create(indexRequest, RequestOptions.DEFAULT);
        //??????????????????
        final boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("index ???????????????" + acknowledged);
    }

    */
/**
     * ????????????
     *//*

    @Test
    @SneakyThrows
    public void queryIndex() {
        final GetIndexRequest getIndexRequest = new GetIndexRequest();
        getIndexRequest.indices("my_first_idnex");
        final GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println("?????????" + getIndexResponse);
        System.out.println("?????? mapping???" + getIndexResponse.getMappings());
    }

    */
/**
     * ????????????
     *//*

    @Test
    @SneakyThrows
    public void deleteIndex() {
        //??????????????????
        final DeleteIndexRequest my_first_idnex = new DeleteIndexRequest("my_first_idnex");
        //???????????????????????????????????????
        final AcknowledgedResponse delete = restHighLevelClient.indices().delete(my_first_idnex, RequestOptions.DEFAULT);
        System.out.println("???????????????" + delete.isAcknowledged());
    }

    */
/**
     * ????????????
     *//*

    @Test
    public void addDoc() throws IOException {
        User user = new User(1L,"??????", 12, "????????????????????????????????????");
        final IndexRequest request = new IndexRequest("my_first_idnex");
        request.id("2");
        request.source(objectMapper.writeValueAsString(user), XContentType.JSON);
        final IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response);
        System.out.println(response.status());
    }

    */
/**
     * ????????????????????????
     * @throws IOException
     *//*

    @Test
    public void existsDoc() throws IOException {
        final GetRequest request = new GetRequest("my_first_idnex", "2");
        final boolean exists = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    */
/**
     *     ??????????????????
     *//*

    @Test
    public void getDoc() throws IOException {
        final GetRequest request = new GetRequest("my_first_idnex", "2");
        final GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSource());
    }

    */
/**
     * ????????????
     *//*

    @Test
    public void updateDoc() throws IOException {
        //UpdateRequest request = new UpdateRequest("my_first_idnex", "1");
        //?????????????????????id??????????????????
        UpdateRequest request = new UpdateRequest("my_first_idnex", "1");
        request.id("2");
        User dam = new User(1l, "??????1???", 99, "??????????????????");
        request.doc(objectMapper.writeValueAsString(dam), XContentType.JSON);
        final UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        System.out.println(response);

    }

    */
/**
     * ????????????
     * @throws IOException
     *//*

    @Test
    public void deleteDoc() throws IOException {
        final DeleteRequest deleteRequest = new DeleteRequest("my_first_idnex");
        deleteRequest.id("2");
        final DeleteResponse response = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    */
/**
     * ????????????
     *//*

    @Test
    public void batchAdd() throws IOException {
        List<User> list = new ArrayList<>();
        User user = new User(1l, "??????", 1, "???????????????");
        User user2 = new User(1l, "??????", 1, "??????");
        User user3 = new User(1l, "??????1", 1, "??????");
        User user4 = new User(1l, "??????2", 1, "??????");
        User user5 = new User(1l, "??????3", 1, "??????");
        User user6 = new User(1l, "??????4", 1, "??????");
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);
        list.add(user);
        final BulkRequest bulkRequest = new BulkRequest();
        for (User tusr : list) {
            bulkRequest.add(new IndexRequest("my_first_idnex")
                            //.id("")  ?????????id?????????id
                    .source(objectMapper.writeValueAsString(tusr), XContentType.JSON));
        }
        final BulkResponse response = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(response.status());

    }
    */
/**
     * ??????
     *//*

    @Test
    public void search() throws IOException {
        SearchRequest searchRequest = new SearchRequest("my_first_idnex");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //????????????
        //term query??????????????????|??????????????????term,?????????????????????????????????,????????????????????????name???????????????
        final TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name.keyword", "??????1");
        sourceBuilder.query(termQueryBuilder);
        //????????????
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

*/
