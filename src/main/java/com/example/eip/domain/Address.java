package com.example.eip.domain;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@XmlRootElement(name = "Address")
public class Address {
    @XmlElement(name = "Id")
    private String id = UUID.randomUUID().toString();

    @XmlElement(name = "PersonId")
    private String personId;

    public Address(String personId) {
        this.personId = personId;
    }
}
