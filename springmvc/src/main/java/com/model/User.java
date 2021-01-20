package com.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotEmpty
	private String userName;
	@NotEmpty
	private String password;
	@Transient
	private String repeatPassword;
	@OneToMany(mappedBy="user")
	private Set<Pets> pets;
	
	public User() {
		super();
	}
	public User(int userId, String userName, String password, String repeatPassword, Set<Pets> pets) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.repeatPassword = repeatPassword;
		this.pets = pets;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	public Set<Pets> getPets() {
		return pets;
	}
	public void setPets(Set<Pets> pets) {
		this.pets = pets;
	}

}
