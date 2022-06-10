package br.com.carv.springcourse.service;

import java.util.List;

import br.com.carv.springcourse.model.User;

public interface UserService {
	
	void saveUser(User user);
	
	void deleteUser(Long id); 
	
	User findUserById(Long id);
	
	void updateUser(User user);
	
	List<User> findAllUsers();
	
	List<User> findUserByEmail(String email); 
	
	List<User> findUserByName(String name);
	

}
