package com.ditravo.service.microservice;

import org.springframework.data.annotation.Id;

public class Person {
    public String name;
    @Id
    public String id;
    public String surname;

    public Person(){}

    public Person(String name, String surname){
        this.name = name;
        this.surname=surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
