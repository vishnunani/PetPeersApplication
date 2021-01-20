package com.dao;

import java.util.List;

import com.model.Pets;

public interface GetPetsDao {
	
	public List<Pets> getPetsFromDb();

}
