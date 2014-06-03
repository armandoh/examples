package com.example.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.example.dto.Person;
import com.example.model.PersonManager;
import com.example.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("PersonService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonManager personMgr;
	
	@GET
	@Path("/helloWorld")
	public String helloWorld() {
		return "Hello World, Stranger!";
	}

	@GET
	@Path("/person")	
	@Produces("application/json")	
	public Person getPerson(@QueryParam("name") String name) {
		Person person = personMgr.getPerson(name);		
		return person;
	}

	@GET
	@Path("/people")
	@Produces("application/json")	
	public List<Person> getPeople() {
		
		return personMgr.getPeople();
	}

	@GET	
	@Produces("application/json")		
	@Path("/peopleByAge/{age}")
	public List<Person> getPeopleByAge(@PathParam("age") int age) {
		
		return personMgr.getPersonByAge(age);
	}

	@POST
	@Path("/add")
	@Consumes("application/json")	
	public String addPerson(Person person) {
		
		return personMgr.addPerson(person);
	}

	@POST
	@Path("/delete")
	@Consumes("application/json")	
	public String deletePerson(Person person) {
		
		return personMgr.deletePerson(person);
	}
	
	
}
