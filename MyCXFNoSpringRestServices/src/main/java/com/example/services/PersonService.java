package com.example.services;

import java.util.List;

import com.example.dto.Person;

public interface PersonService {
    public String helloWorld();
    public Person getPerson(String name);
    public String addPerson(Person person);
    public String deletePerson(Person person);
    public List<Person> getPeople();
    public List<Person> getPeopleByAge(int age);
}
