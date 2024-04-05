package com.nashtechelastic.repository;

import com.nashtechelastic.model.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerCrudRepository extends ElasticsearchRepository<Customer,String> {
    List<Customer> findByFirstName(String firstName);


}
