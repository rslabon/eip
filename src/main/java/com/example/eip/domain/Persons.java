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
@XmlRootElement(name = "Persons")
public class Persons {
    @XmlElement(name = "Person")
    private List<Person> people = new ArrayList<>();

    public static Persons whatever(int numOfPeople) {
        Persons persons = new Persons();
        persons.people = IntStream.range(0, numOfPeople + 1)
                .mapToObj(Void -> Person.whatever())
                .collect(Collectors.toList());
        return persons;
    }

    public static void main(String[] args) throws Exception {
        Marshaller m = JAXBContext.newInstance(Persons.class).createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(whatever(10), System.out);
    }
}


