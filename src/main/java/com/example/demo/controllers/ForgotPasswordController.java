package com.example.demo.controllers;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Account;
import com.example.demo.Repositories.AccountDAO;
import com.example.demo.Services.MailerService;

@Controller
public class ForgotPasswordController {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private MailerService mailerService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
    @GetMapping("/forgotPassword")
    public String forgotPassword() {
        return "forgot-password";
    }
    
    @PostMapping("/forgotPassword")
    public String processForgotPassword(Model model, 
                                        @RequestParam("username") String username,
                                        @RequestParam("email") String email) {

        Account account = accountDAO.findByUsernameAndEmail(username, email);

        if (account == null) {
            model.addAttribute("error", "Invalid username or email.");
            return "forgot-password";
        }

        String newPassword = generateRandomPassword(); 
        account.setPass(passwordEncoder.encode(newPassword));
        accountDAO.save(account);

        String emailContent = "Your new password is: " + newPassword;

        try {
            mailerService.send(email, "Password Reset", emailContent);
            model.addAttribute("mess", "Password reset successful. Please check your email.");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to send email.");
            e.printStackTrace();
        }
        return "forgot-password";
    }

    private String generateRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(10); // Ví dụ tạo mật khẩu 10 ký tự
    }
}
