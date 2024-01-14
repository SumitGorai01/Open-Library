package com.project.openlibrary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users") // uniqueConstraints = @UniqueConstraint(columnNames="email"))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;

	@Column(name = "name")
	@NotBlank(message = "Name can not be blank!")
	private String name;

	@Column(name = "email")
	@NotBlank(message = "Email can not be blank!")
	@Email(message = "Please enter a valid email.")
	private String email;

	@Column(name = "contact_no")
	@NotBlank(message = "Contact can not be blank!")
	private String contactNo;

	@Column(name = "password")
	@NotBlank(message = "Password can not be blank!")
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo + ", password="
				+ password + "]";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Integer id, @NotBlank(message = "Name can not be blank!") String name,
			@NotBlank(message = "Email can not be blank!") @Email(message = "Please enter a valid email.") String email,
			@NotBlank(message = "Contact can not be blank!") String contactNo,
			@NotBlank(message = "Password can not be blank!") String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.password = password;
	}

}
