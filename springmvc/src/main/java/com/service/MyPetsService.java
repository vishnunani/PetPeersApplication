package com.service;

import java.util.List;

import com.model.Pets;
public interface MyPetsService {
	
	public List<Pets> getMyPets(int userId);

}
