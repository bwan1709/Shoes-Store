package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Entity.Account;
import com.example.demo.Entity.Roles;
import com.example.demo.Repositories.AccountDAO;
import com.example.demo.Services.SessionService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	@Autowired
	SessionService session;

	@GetMapping("/login")
	public String login() {
		return "Login";
	}

//    @PostMapping("/login")
//    public String processLogin(@RequestParam("user") String username, @RequestParam("pass") String password, Model model) {
//        // Tìm tài khoản trong cơ sở dữ liệu dựa trên username
//        Account account = accountDAO.findByUsername(username);
//        if (account != null && account.getPass().equals(password)) {
//            // Đăng nhập thành công, chuyển hướng đến trang dashboard hoặc trang chính
//        	session.setAttribute("acc", account);
//            return "redirect:/home"; // Thay thế "/dashboard" bằng URL của trang bạn muốn chuyển hướng
//        } else {
//            // Đăng nhập không thành công, hiển thị thông báo lỗi trên trang đăng nhập
//            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác");
//            return "Login";
//        }
//    }
	@PostMapping("/signup")
	public String processSignup(@RequestParam("user") String username, @RequestParam("pass") String password,
			@RequestParam("email") String email, Model model) {
		Optional<Account> existingAccount = accountDAO.findByUsername(username);
		if (existingAccount.isPresent()) {
			model.addAttribute("error", "Tên người dùng đã được sử dụng");
			return "Login";
		}
		Account newAccount = new Account();
		newAccount.setUsername(username);
		newAccount.setPass(passwordEncoder.encode(password));
		newAccount.setEmail(email);
		newAccount.setIsAdmin(Roles.CUSTOMER);
		accountDAO.save(newAccount);
		return "redirect:/login";
	}

	@RequestMapping("/logout")
	public String logout() {
		if (session != null) {
			session.remove("acc");
		}
		return "Home";
	}
	@RequestMapping("/login/success")
	public String handleLoginSuccess() {
		return "redirect:/";
	}

	@RequestMapping("/accessDenied")
	public String accessDenied() {
		return "access/accessDenied";
	}

	@RequestMapping("/login/failure")
	public String handleLoginFailure(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "Email or password is not true");
		return "redirect:/login";
	}
}
