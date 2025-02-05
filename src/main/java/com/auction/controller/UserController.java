package com.auction.controller;

import com.auction.model.User;
import com.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

@Autowired
private UserService userService;

// Show registration form (for simplicity)
@GetMapping("/register")
public String showRegistrationForm(ModelMap model) {
model.put("user", new User());
return "register"; // Thymeleaf template name for registration.
}

// Handle registration form submission.
@PostMapping("/register")
public String register(User user) {
userService.register(user);
return "redirect:/login"; // Redirect to login after registration.
}

// Show login form.
@GetMapping("/login")
public String showLoginForm() {
return "login"; // Thymeleaf template name for login.
}

// Handle login logic (simplified).
@PostMapping("/login")
public String login(User user, ModelMap model) {
// Add your authentication logic here (e.g., check credentials).
User foundUser = userService.findByUsername(user.getUsername());
if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
// Successful login logic here.
return "redirect:/auctions"; // Redirect to auctions page.
}
model.put("error", "Invalid credentials");
return "login"; // Show error on the same page.
}
}
