package com.example.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import com.example.dto.Person;
import com.example.model.PersonManager;
import com.example.services.PersonService;

@Path(value = "rest")
public class PersonServiceImpl implements PersonService {

	PersonManager personMgr = new PersonManager();
	
	public PersonServiceImpl (){
		System.out.println(" Jersey REST being instantiated");
	}
	
	@GET
	@Path("/helloWorld")
	public String helloWorld() {
		return "Hello World, Stranger!";
	}

	
	@GET
	@Path("/person")	
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(@QueryParam("name") String name) {
		Person person = personMgr.getPerson(name);		
		return person;
	}

	@GET
	@Path("/people")
	@Produces({MediaType.APPLICATION_JSON})	
	public List<Person> getPeople() {
		
		return personMgr.getPeople();
	}

	@GET	
	@Produces({MediaType.APPLICATION_JSON})		
	@Path("/peopleByAge/{age}")
	public List<Person> getPeopleByAge(@PathParam("age") int age) {
		
		return personMgr.getPersonByAge(age);
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)	
	public String addPerson(Person person) {
		System.out.println("Adding person... " + person.getName());
		return personMgr.addPerson(person);
	}

	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)	
	public String deletePerson(Person person) {
		System.out.println("Deleting person... " + person.getName());
		return personMgr.deletePerson(person);
	}
	
	
}
