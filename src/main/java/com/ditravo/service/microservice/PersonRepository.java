package com.ditravo.service.microservice;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    public Person findByName(String name);
    public Person findBySurname(String surname);

}
