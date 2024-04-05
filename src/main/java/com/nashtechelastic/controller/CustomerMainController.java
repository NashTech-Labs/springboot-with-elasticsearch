package com.nashtechelastic.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.nashtechelastic.model.Customer;
import com.nashtechelastic.repository.CustomerCrudRepository;
import com.nashtechelastic.service.ElasticQueryDslService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/customer")
public class CustomerMainController {
    @Autowired
    private CustomerCrudRepository repository;
    @Autowired
    private ElasticQueryDslService queryDslService;

    @PostMapping(value = "/addCustomers",consumes = MediaType.APPLICATION_JSON_VALUE)
    public int saveCustomer(@RequestBody List<Customer> customers) {
        repository.saveAll(customers);
        return customers.size();
    }
    @GetMapping("/findAll")
    public Iterable<Customer> findAllCustomer() {
        return repository.findAll();
    }
    @GetMapping("/findByFirstName/{firstName}")
    public List<Customer> findByFirstName(@PathVariable String firstName) {
        return repository.findByFirstName(firstName);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable String id) {
         repository.deleteById(id);
    }
    @GetMapping("/matchAll")
    public String matchAllQuery() throws IOException {
        SearchResponse<Map> mapSearchResponse = queryDslService.matchAllServices();
        System.out.println(mapSearchResponse.hits().hits().toString());
        return mapSearchResponse.hits().hits().toString();
    }
    @GetMapping("/matchAllCustomer")
    public List<Customer> matchAllCustomer() throws IOException {
        SearchResponse<Customer> mapSearchResponse = queryDslService.matchAllCustomer();
        System.out.println(mapSearchResponse.hits().hits().toString());
      List<Hit<Customer>>listOfHits=mapSearchResponse.hits().hits();
      List<Customer> customers=new ArrayList<>();
      listOfHits.stream().forEach(s->customers.add(s.source()));
      return customers;
    }
    @GetMapping("/matchAllCustomer/{first}")
    public List<Customer> matchAllCustomer(@PathVariable String first) throws IOException {
        SearchResponse<Customer> mapSearchResponse = queryDslService.matchAllCustomerByFirstName(first);
        System.out.println(mapSearchResponse.hits().hits().toString());
        List<Hit<Customer>>listOfHits=mapSearchResponse.hits().hits();
        List<Customer> customers=new ArrayList<>();
        listOfHits.stream().forEach(s->customers.add(s.source()));
        return customers;
    }
}
