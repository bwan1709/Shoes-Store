package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Entity.Account;
import com.example.demo.Services.AccountService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EditProfileController {

	@Autowired
	private AccountService accountService;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/editProfile")
	public String showEditProfileForm(HttpSession session, Model model) {
		Account sessionAccount = (Account) session.getAttribute("acc");

		if (sessionAccount == null) {
			return "redirect:/login";
		}

		model.addAttribute("account", sessionAccount);
		return "EditProfile";
	}

	@PostMapping("/editProfile")
	public String editProfile(HttpSession session, @RequestParam String username, @RequestParam String password,
			@RequestParam String email,@RequestParam String address,@RequestParam String phoneNumber, Model model) {
		Account sessionAccount = (Account) session.getAttribute("acc");
		if (sessionAccount == null) {
			return "redirect:/login";
		}
		sessionAccount.setUsername(username);
		sessionAccount.setPass(passwordEncoder.encode(password));
		sessionAccount.setEmail(email);
		sessionAccount.setAddress(address);
		sessionAccount.setPhoneNumber(phoneNumber);
		try {
			accountService.updateAccount(sessionAccount);
			session.setAttribute("acc", sessionAccount);
			model.addAttribute("mess", "Cập nhật hồ sơ thành công!");
		} catch (Exception e) {
			model.addAttribute("error", "Cập nhật hồ sơ thất bại: " + e.getMessage());
		}

		return "EditProfile";
	}
}
