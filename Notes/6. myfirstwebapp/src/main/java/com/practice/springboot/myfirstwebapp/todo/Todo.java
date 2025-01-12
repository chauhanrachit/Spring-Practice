package com.practice.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;

//Should be stored in DataBase (Ex - MySQL)
//But for now , using Static List of todos => will shift later to database(H2, MySQL)

//JPA allows us to map our bean to the Database Table, done by adding a simple annotation @Entity
//Bean -> Database Table
//We need to define an Id(Primary Key) for an entity by @Id annotations
//@Entity(name="TodoTable") - If we want to create a different name , or already have table with a different name 
//which we want to use in the DB
@Entity
public class Todo {
	
	@Id
	@GeneratedValue
	private int id;
	
//	@Column(name="User_Name") - To make a column with different name in the DB
	private String username;
	
	@Size(min=10,message = "Enter atleast 10 Characters")
	private String description;
	
	@FutureOrPresent(message = "Enter A Valid Present or Future Data")
	private LocalDate targetDate;
	private boolean done;
	
	public Todo() {
	}
	
	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		//targetDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targateDate) {
		this.targetDate = targateDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}

}
