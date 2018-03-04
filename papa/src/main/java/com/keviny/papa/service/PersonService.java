package com.keviny.papa.service;

import com.keviny.papa.dao.PersonRepository;
import com.keviny.papa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public void savePerson(Person person){
        personRepository.save(person);
    }

    @Cacheable(value = "hello", key = "#id+':test'")
    public String findPerson(Integer id){
        return personRepository.findOne(id).getName();
    }
}
