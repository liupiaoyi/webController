package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int pid;

	private int age;

	private String name;

	public Person() {
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(int pid, int age, String name) {
		super();
		this.pid = pid;
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", age=" + age + ", name=" + name + "]";
	}

}