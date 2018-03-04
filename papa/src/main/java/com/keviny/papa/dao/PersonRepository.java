package com.keviny.papa.dao;

import com.keviny.papa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person,Integer> {
}
