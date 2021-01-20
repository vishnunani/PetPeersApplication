package com.dao;

import java.util.List;

import com.model.Pets;

public interface MyPetsDao {
	
	public List<Pets> getMyPetsDb(int userId);

}
