package org.pi.consumer;

import java.util.List;

import org.pi.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByEmail(String email);
    
    @Query("select role as role from User where email=?1")
    public List<String> findRoleByEmail(String email);
    
    
}