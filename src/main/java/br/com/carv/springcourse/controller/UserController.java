package br.com.carv.springcourse.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.carv.springcourse.model.User;
import br.com.carv.springcourse.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService; 
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public List<User> findAll() {
		return userService.findAllUsers();
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@RequestBody User user) {
		userService.saveUser(user);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable("id") Long id) {
		System.out.println(id);		
		userService.deleteUser(id);
	}
	
	@GetMapping("/findUserByName")
	@ResponseStatus(HttpStatus.OK)
	public List<User> findUserByName(@RequestParam("name") String name) {
		return userService.findUserByName(name);
	}
	
	@GetMapping("/findUserByEmail")
	@ResponseStatus(HttpStatus.OK)
	public List<User> findUserByEmail(@RequestParam("email") String email) {
		return userService.findUserByEmail(email);
	}
	
	@GetMapping("/findUserById")
	@ResponseStatus(HttpStatus.OK)
	public User findUserById(@RequestParam("id") Long id) {
		return userService.findUserById(id);
		
	}

}
