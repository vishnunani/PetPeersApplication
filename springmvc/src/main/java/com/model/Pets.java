package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "pets")
public class Pets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petId;
	@NotEmpty
	private String petName;
	@NotEmpty
	private String petPlace;
	@NotNull
	private int petAge;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId",referencedColumnName="userId", nullable=true)
	private User user;
	
	public Pets() {
		super();
	}
	public Pets(int petId, String petName, String petPlace, int petAge, User user) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.petPlace = petPlace;
		this.petAge = petAge;
		this.user = user;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getPetPlace() {
		return petPlace;
	}
	public void setPetPlace(String petPlace) {
		this.petPlace = petPlace;
	}
	public int getPetAge() {
		return petAge;
	}
	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}
	public User getUserId() {
		return user;
	}
	public void setUserId(User user) {
		this.user = user;
	}
	
	
}
