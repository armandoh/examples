package com.example.model;

import java.util.ArrayList;
import java.util.List;

import com.example.dto.Person;
import com.example.dto.SEX;

public class PersonManager {

	private static List<Person> people = null;

	public PersonManager() {
		System.out.println("--> Starting person Manager (Apache CXF without Spring)");
		initPeople();
	}

	private void initPeople() {
		people = new ArrayList<Person>();
		Person p = new Person();
		p.setName("Smart");
		p.setLastname("Guy");
		p.setAge(19);
		p.setSex(SEX.MALE);

		people.add(p);

		p = new Person();
		p.setName("Awesome");
		p.setLastname("Girl");
		p.setAge(24);
		p.setSex(SEX.FEMALE);

		people.add(p);

	}

	public Person getPerson(String name) {
		if (people != null) {
			for (Person p : people) {
				if (p.getName().equalsIgnoreCase(name)) {
					return p;
				}
			}
		}

		return new Person();
	}
	
	public List<Person> getPersonByAge(int age) {
		List<Person> peopleAge = new ArrayList<Person>();
		
		if (people != null) {
			for (Person p : people) {
				if (p.getAge() == age) {
					peopleAge.add(p);
				}
			}
		}

		return peopleAge;
	}

	public String addPerson(Person p) {
		if (people != null) {
			people.add(p);
			return "Add was successful";
		}
		return "Fail!";
	}

	public String deletePerson(Person p) {
		if (people != null) {
			if(!people.contains(p)){
				return "Person is not part of the people list!";
			}
			if (people.contains(p) && people.remove(p)) {
				return "Delete was successful";
			}
		}
		return "Fail!";
	}

	public List<Person> getPeople() {
		return people;
	}

}
