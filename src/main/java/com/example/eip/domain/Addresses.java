package com.example.eip.domain;

import lombok.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@XmlRootElement(name = "Addresses")
public class Addresses {
    @XmlElement(name = "Address")
    private List<Address> addresses = new ArrayList<>();

    public static Addresses whatever(int numOfAddresses, Persons persons) {
        Addresses addresses = new Addresses();
        addresses.addresses = IntStream.range(0, numOfAddresses + 1)
                .mapToObj(Void -> new Address(Randoms.oneOf(persons.getPeople()).getId()))
                .collect(Collectors.toList());
        return addresses;
    }

    public static void main(String[] args) throws Exception {
        Marshaller m = JAXBContext.newInstance(Addresses.class).createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(whatever(5, Persons.whatever(10)), System.out);
    }
}
