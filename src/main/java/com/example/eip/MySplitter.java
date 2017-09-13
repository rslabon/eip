package com.example.eip;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySplitter extends RouteBuilder {

    @Autowired
    private JmsProducer jmsProducer;

    @Override
    public void configure() throws Exception {
        jmsProducer.send("0");
        jmsProducer.send("1");

        from("jms:invoices")
                .log("MySplitter: '${body}'")
                .choice()
                    .when(exchange -> exchange.getIn().getBody().toString().contains("0"))
                        .to("jms:zero")
                    .when(exchange -> exchange.getIn().getBody().toString().contains("1"))
                        .to("jms:one");
    }
}