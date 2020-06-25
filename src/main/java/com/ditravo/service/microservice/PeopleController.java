package com.ditravo.service.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PeopleController {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/getperson")
    public String getPerson(@RequestParam(defaultValue = "george") String name){
        return repository.findByName(name).toString();

    }

    @PostMapping("/addperson")
    public String postPerson(@RequestParam(defaultValue ="george floyd") String name, String surname){
        if(repository.findByName(name) != null){
            return "That Person is already registered to the db !";
        }else{
            repository.save(new Person(name,surname));
            return ("Post Worked with name : "+name+"and surname: "+surname);
        }

    }

    @PutMapping("/putperson")
    public String putPerson(@RequestParam(required = true) String name, String surname){
        if(repository.findByName(name)!= null){
            repository.delete(repository.findByName(name));
            repository.save(new Person(name,surname));
            return ("Updated to :"+repository.findByName(name).toString());
        }else{
            return ("No such person with name: "+name+"exists !");
        }

    }

    @DeleteMapping("/deleteperson")
    public String deletePerson(@RequestParam(required = true) String name){
        if(repository.findByName(name)!=null){
            String surname = repository.findByName(name).getSurname();
            repository.delete(repository.findByName(name));
            return ("Person deleted with name:" +name+" ,surname: "+surname);
        }else {
            return "No such person exists!";
        }
    }

}
