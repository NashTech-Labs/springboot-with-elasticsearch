package com.nashtechelastic.util;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

import java.util.function.Supplier;

public class ElasticUtil {
    public static Supplier<Query> supplier() {
        Supplier<Query> supplier=()-> Query.of((q->q.matchAll(matchAllQuery())));
        return supplier;
    }

    public static MatchAllQuery matchAllQuery() {
        return new MatchAllQuery.Builder().build();
    }

    public static Supplier<Query> supplierWithName(String firstName) {
        Supplier<Query> supplier=()-> Query.of((q->q.match(matchAllQueryWithName(firstName))));
        return supplier;
    }
    public static MatchQuery matchAllQueryWithName(String firstName) {
        return new MatchQuery.Builder().field("firstName").query(firstName).build();
    }
}
