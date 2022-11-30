# es-study
es学习

#分页方案

##深度分页问题
```$xslt
localhost:9200/order_info_index/_settings
{
  "index": {
    "max_result_window": 20000
  }
}
```


##分页
*1、from size*    
*2、search_after + pit ***推荐使用****  
*3、scroll*