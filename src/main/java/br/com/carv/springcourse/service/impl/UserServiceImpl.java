package br.com.carv.springcourse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.carv.springcourse.exception.NotFoundException;
import br.com.carv.springcourse.model.User;
import br.com.carv.springcourse.repository.UserRepository;
import br.com.carv.springcourse.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	private final UserRepository userRepository; 
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void saveUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public void deleteUser(Long id) {
		Optional<User> userResult = userRepository.findById(id); 
		if (userResult.isEmpty()) {
			throw new NotFoundException("User not found! Id: " + id);
		}
		userRepository.delete(userResult.get());
	}

	@Override
	public User findUserById(Long id) {
		Optional<User> userResult = userRepository.findById(id);
		return userResult.orElseThrow(() -> new NotFoundException("User not found! Id: " + id));
	}

	@Override
	public void updateUser(User user) {
		if (user.getId() == null) {
			throw new NotFoundException("Could not update user because he does not exist!");
		}
		userRepository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public List<User> findUserByName(String name) {
		return userRepository.findUserByName(name);
	}
	

}
