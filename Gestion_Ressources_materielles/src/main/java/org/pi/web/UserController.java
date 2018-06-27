package org.pi.web;

import java.util.List;

import org.pi.consumer.UserJpaRepository;
import org.pi.consumer.UserRepository;
import org.pi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@RequestMapping("/")
	public String login()
	{
		return "home";
	}
	
	@GetMapping("/user")
	public String afficherUser(Model model)
	{
		List<User> users = userJpaRepository.findAll();
		model.addAttribute("users",users);
		return "afficherUser";
	}
}
