package com.everis.bootcamp.pruebamock;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	
	private List<String> nomUsers = new ArrayList<>();
	
	public List<String> getAllNames(){
		return nomUsers; 
	}

	public String getFirstName() {
		return nomUsers.size() > 0 ? nomUsers.get(0) : "";
	}
	
	public int addNomUser(String nom) {
		nomUsers.add(nom);
		return 1;
	}
}
