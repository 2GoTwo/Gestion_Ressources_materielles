package org.pi.web;

import org.pi.consumer.UserRepository;
import org.pi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
	public String login()
	{
		//role Admin
		User user = new User();
		user.setEmail("meskine");
		user.setPassword(new BCryptPasswordEncoder().encode("1234"));
		user.setRole("ROLE_ADMIN");
		userRepository.save(user);
		//role user
		User userx = new User();
		userx.setEmail("bahi");
		userx.setPassword(new BCryptPasswordEncoder().encode("1234"));
		userx.setRole("ROLE_USER");
		userRepository.save(userx);
		return "home";
	}
}
