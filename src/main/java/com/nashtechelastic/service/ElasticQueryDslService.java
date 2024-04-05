package com.nashtechelastic.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.nashtechelastic.model.Customer;
import com.nashtechelastic.util.ElasticUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;

@Service
public class ElasticQueryDslService {
    @Autowired
    private ElasticsearchClient elasticsearchClient;

    // Matching all the Services
    public SearchResponse<Map> matchAllServices() throws IOException {
        Supplier<Query> supplier = ElasticUtil.supplier();
        SearchResponse<Map> searchResponse = elasticsearchClient.search(s -> s.query(supplier.get()), Map.class);
        System.out.println("Elastic Search Query is " + supplier.get().toString());

        return searchResponse;
    }

    // Match all the index
    public SearchResponse<Customer> matchAllCustomer() throws IOException {
        Supplier<Query> supplier = ElasticUtil.supplier();
        SearchResponse<Customer> searchResponse = elasticsearchClient.search(s -> s.index("customer").query(supplier.get()), Customer.class);
        System.out.println("Elastic Search Query is " + supplier.get().toString());

        return searchResponse;
    }
    //Match by firstname
    public SearchResponse<Customer> matchAllCustomerByFirstName(String firstname) throws IOException {
        Supplier<Query> supplier = ElasticUtil.supplierWithName(firstname);
        SearchResponse<Customer> searchResponse = elasticsearchClient.search(s -> s.index("customer").query(supplier.get()), Customer.class);
        System.out.println("Elastic Search Query is " + supplier.get().toString());

        return searchResponse;
    }


}
