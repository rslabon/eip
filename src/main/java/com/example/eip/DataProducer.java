package com.example.eip;

import com.example.eip.domain.Addresses;
import com.example.eip.domain.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostConstruct
    public void produce() {
        Persons persons = Persons.whatever(1000);
        Addresses addresses = Addresses.whatever(1000, persons);

        jmsTemplate.convertAndSend("persons", persons);
        jmsTemplate.convertAndSend("addresses", addresses);
    }
}
