package com.example.eip.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PersonSplitter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:persons")
                .log("persons: '${body}'")
                .split()
                .tokenizeXML("Person", "Persons")
                .streaming()
                .to("jms:person");
    }
}