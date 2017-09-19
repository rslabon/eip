package com.example.eip;

import com.example.eip.domain.Persons;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JmsConfig {
    @Bean
    public MarshallingMessageConverter messageConverter() {
        MarshallingMessageConverter messageConverter = new MarshallingMessageConverter();
        messageConverter.setMarshaller(getMarshaller());
        messageConverter.setUnmarshaller(getMarshaller());
        return messageConverter;
    }

    @Bean
    public Jaxb2Marshaller getMarshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan(Persons.class.getPackage().getName());
        Map<String, Object> map = new HashMap<>();
        map.put("jaxb.formatted.output", true);
        jaxb2Marshaller.setMarshallerProperties(map);
        return jaxb2Marshaller;
    }
}
