package org.pi.web;

import java.security.Principal;
import java.util.List;

import org.pi.business.user.UserService;
import org.pi.consumer.UserJpaRepository;
import org.pi.consumer.UserRepository;
import org.pi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Autowired
	private UserService userService;
	
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
	
	@GetMapping("/user/addUser")
	public String userForm(Model model)
	{
		User user = new User();
		user.setRole("ROLE_USER");
		model.addAttribute("user",user);
		return "addUser";
	}
	
	@PostMapping("/user/addUser")
	public String addUser(User user)
	{
		userJpaRepository.save(user);
		return "redirect:/user";
	}
	
	@GetMapping("/editProfil")
	public String editProfil(Model model,Authentication authentication)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User enseignant = (User) auth.getPrincipal();
		String email = enseignant.getEmail();
		User user = userService.chercherUser(email);
		model.addAttribute("user",user);
		return "editProfil";
	}
}
