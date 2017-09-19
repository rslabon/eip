package com.example.eip.domain;


import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@XmlRootElement(name = "Person")
public class Person {
    @XmlElement(name = "Id")
    private String id = UUID.randomUUID().toString();
    @XmlElement(name = "FirstName")
    private String firstName;
    @XmlElement(name = "LastName")
    private String lastName;
    @XmlElement(name = "Age")
    private int age;

    public static Person whatever() {
        Person person = new Person();
        person.firstName = Randoms.string();
        person.lastName = Randoms.string();
        person.age = Randoms.positiveInt(1, 100);
        return person;
    }
}
