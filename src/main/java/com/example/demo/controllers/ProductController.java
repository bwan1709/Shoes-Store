package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Product;
import com.example.demo.Repositories.ProductDAO;



@Controller
public class ProductController {
	@Autowired
	ProductDAO dao;
	@RequestMapping("/single-product/{id}")
	public String detail(@PathVariable("id") Integer id, Model model) {
		Product product = dao.findById(id).orElse(null);
		model.addAttribute("detail", product);
		return "DetailProduct";
	}
	
}
