package br.com.carv.springcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.carv.springcourse.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "SELECT u FROM User u WHERE u.name LIKE %:name%")
	List<User> findUserByName(@Param("name") String name);
	
	@Query(value = "SELECT u FROM User u WHERE u.email LIKE %:email%")
	List<User> findUserByEmail(@Param("email") String email);

}
