package com.everis.bootcamp.pruebamock;

import java.util.List;

public class UserService {
	
	private UserRepository repo;
	
	public UserService(UserRepository repo) {
		this.repo = repo;
	}

	public List<String> getAllNames(){
		return this.repo.getAllNames();
	}
	
	public String getFirstName() {
		return this.repo.getFirstName();
	}
	
	public int addNomUser(String nom) {
		return this.repo.addNomUser(nom);
	}
}
