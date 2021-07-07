package com.bitirmeTez.sikayetPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bitirmeTez.sikayetPortal.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer>{
	
	Users findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
	
	@Query("select u from Users u")    //This is using a named query method
	public List<Users> findByGetAllUsers();
	
	@Query("select u from Users u where u.username = ?1 and u.password = ?2")    //This is using a named query method
	public Users isLoginUsers(String username,String password);
	
	
	
}
