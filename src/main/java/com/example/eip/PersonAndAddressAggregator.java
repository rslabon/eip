package com.example.eip;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.UseLatestAggregationStrategy;
import org.springframework.stereotype.Service;

@Service
public class PersonAndAddressAggregator extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:person").from("jms:address")
                .log("PersonAndAddressAggregator: '${body}'")
                .aggregate(new UseLatestAggregationStrategy())
                    .body()
                    .completionInterval(500)
                .to("jms:person_address");
    }
}