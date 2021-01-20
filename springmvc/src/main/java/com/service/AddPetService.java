package com.service;

import com.model.Pets;

public interface AddPetService {
	
	public String registerNewPet(Pets pet,int userId);

}
