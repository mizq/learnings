package com.udemy.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {

	
    @NotNull
    @Size(min=2, max=6)
	private String name;
	@NotNull
	@Min(18)
    private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Person(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
		
	public Person(){}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
