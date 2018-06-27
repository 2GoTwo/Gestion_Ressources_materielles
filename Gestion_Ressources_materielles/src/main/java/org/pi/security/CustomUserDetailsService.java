package org.pi.security;

import java.util.List;

import org.pi.consumer.UserRepository;
import org.pi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	private final org.pi.consumer.UserRepository userRepository;
	
	
	@Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
        
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(email);
		if(null == user){
			throw new UsernameNotFoundException("No user present with username: "+email);
		}else{
			List<String> userRoles=userRepository.findRoleByEmail(email);
			return new CustomUserDetails(user,userRoles);
		}
	}
		
}
