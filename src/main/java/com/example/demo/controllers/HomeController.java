package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Entity.Product;
import com.example.demo.Repositories.ProductDAO;

@Controller
public class HomeController {
	@Autowired
	ProductDAO productDAO;

	@GetMapping("/")
	public String home(Model model) {
		List<Product> listPrd = productDAO.findAll();
		model.addAttribute("listPrd", listPrd);
		return "Home";
	}

	@GetMapping("/home")
	public String home1(Model model) {
		return "redirect:/";
	}

}
