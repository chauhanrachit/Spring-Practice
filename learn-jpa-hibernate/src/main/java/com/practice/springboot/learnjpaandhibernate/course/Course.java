package com.practice.springboot.learnjpaandhibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
//@Entity(name="course") -> table name if it is different 
public class Course {
	@Id
	private long id;
	
	//@Column(name="name")	 //not needed as same column name present in the table
	private String name;
	
	//@Column				 //not needed as same column name present in the table
	private String author;
	
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Course() {
		
	}
	
	public long getId() {
		return id;
	}

//	public Course(long id) {
//		super();
//		this.id = id;
//	}
	
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public String getName() {
		return name;
	}


	public String getAuthor() {
		return author;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
}
