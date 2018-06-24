package org.pi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {
	@GetMapping("/")
	public String signIn()
	{
		return "tables";
	}
}
