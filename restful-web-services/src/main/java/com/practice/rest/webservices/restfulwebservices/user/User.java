package com.practice.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "User_details")
public class User {
	
	protected User() {}
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 2,message = "Name Should have atleast 2 Characters")
	//@JsonProperty("user_name")	//To Customize field names in response
	private String name;
	
	@Past(message = "BirthDate should be of past")
	//@JsonProperty("birth_date")
	private LocalDate birthDate;
	
	
	//We want to have user and relationship with the posts.So, the user has what kind of relation with Post=
	//Since a single user can have multiple posts, -- One to Many Relationship
	//mappedBy -> which field in Post entity owns this relationship (here, User user)
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
	//We are using User Bean as part of our REST API responses, and we'll also be using Post Bean as part of our REST API 
	//responses as well. And, we don't want Post to be part of the JSON Responses for the User Bean.
	//That's why we would add @JsonIgnore in here.
	
	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
}
