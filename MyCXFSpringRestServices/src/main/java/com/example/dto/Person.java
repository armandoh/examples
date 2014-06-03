package com.example.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Person")
@XmlType(propOrder = { "name", "lastname", "age", "sex" })
public class Person {
	private String name;
	private int age;
	private String lastname;
	private SEX sex;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public SEX getSex() {
		return sex;
	}

	public void setSex(SEX sex) {
		this.sex = sex;
	}

	public boolean equals(Object o) {
		Person p = (Person) o;
		/*
		System.out.println("Comparing ... ");
		System.out.println(this.toString());
		System.out.println(p.toString());
		*/
		if (p.getName().equalsIgnoreCase(this.name)
				&& p.getLastname().equalsIgnoreCase(this.lastname)
				&& p.getAge() == this.age && p.getSex() == this.sex) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("name : ").append(name).append(", ");
		sb.append("lastname : ").append(lastname).append(", ");
		sb.append("age : ").append(age).append(", ");
		sb.append("sex : ").append(sex);
				
		return sb.toString();
	}
}
