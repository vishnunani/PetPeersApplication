package com.dao;

import com.model.Pets;


public interface AddPetDao {

	public String getNewPetDetails(Pets pet,int  userId);
	
}
