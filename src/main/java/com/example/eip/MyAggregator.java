package com.example.eip;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.UseLatestAggregationStrategy;
import org.springframework.stereotype.Service;

@Service
public class MyAggregator extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:zero").from("jms:one")
                .log("MyAggregator: '${body}'")
                .aggregate(new UseLatestAggregationStrategy())
                    .body()
                    .completionInterval(500)
                .to("jms:zero_and_one");
    }
}