package com.example.controllers;

import java.util.List;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.Greeting;
import com.example.dto.Person;
import com.example.model.PersonManager;

@Controller
public class PersonController {// implements PersonService {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private PersonManager personMgr;

	@RequestMapping("/hello")
	public @ResponseBody
	Greeting greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template,
				name));
	}

	@RequestMapping("/person")
	public @ResponseBody
	Person getPerson(
			@RequestParam(value = "name", required = false, defaultValue = "Smart") String name) {
		Person person = personMgr.getPerson(name);
		return person;
	}

	@RequestMapping("/people")
	public @ResponseBody
	List<Person> getPeople() {

		return personMgr.getPeople();
	}

	@RequestMapping("/peopleByAge/{age}")
	public @ResponseBody
	List<Person> getPeopleByAge(@PathVariable(value = "age") int age) {

		return personMgr.getPersonByAge(age);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	String addPerson(@RequestBody Person person) {
		System.out.println("Adding person... " + person.getName());
		return personMgr.addPerson(person);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	String deletePerson(@RequestBody Person person) {
		System.out.println("Deleting person... " + person.getName());
		return personMgr.deletePerson(person);
	}

}
