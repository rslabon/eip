package com.example.eip.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class AddressSplitter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:addresses")
                .log("addresses: '${body}'")
                .split()
                .tokenizeXML("Address", "Addresses")
                .streaming()
                .to("jms:address");
    }
}