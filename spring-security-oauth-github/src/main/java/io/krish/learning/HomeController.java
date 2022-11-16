package io.krish.learning;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		String username="";
		Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if(principal instanceof OAuth2AuthenticatedPrincipal) {
			username = ((OAuth2AuthenticatedPrincipal) principal).getAttribute("name");
		}
		return ("<h1>Welcome "+username+"</h1>");
	}
}
