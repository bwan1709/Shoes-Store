package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Account;
import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Product;
import com.example.demo.Repositories.AccountDAO;
import com.example.demo.Services.CartService;
import com.example.demo.Services.ProductService;
import com.example.demo.Services.SessionService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ManagerCart {
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private AccountDAO userRepo;
	@Autowired
	private SessionService session;

	@GetMapping("managerCart")
	public String managerCart(Model model) {
		Account account = (Account) session.get("acc");
		List<Cart> listCart = cartService.getAllCartItems();
		List<Product> listProduct = productService.getAllProducts();
		Integer accountId = account != null ? account.getId() : null;
		model.addAttribute("listCart", listCart);
		model.addAttribute("listProduct", listProduct);
		System.out.println(listCart);
		model.addAttribute("count", String.valueOf(cartService.getCount(accountId)));
		model.addAttribute("totalCartAmount", String.valueOf(cartService.getTotalCartAmount(accountId)));
		return "Cart";
	}

	@PostMapping("/addCart")
	public String addToCart(@RequestParam("pid") int productId, @RequestParam("quantity") int quantity,
			@RequestParam("size") String size, Model model) {
		Account account = (Account) session.get("acc");
		if (account != null) {
			cartService.addProductToCart(productId, quantity, size, account.getId());
		} else {
			return "redirect:/login"; 
		}
		List<Cart> listCart = cartService.getAllCartItems();
		List<Product> listProduct = productService.getAllProducts();
		model.addAttribute("listCart", listCart);
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("count", String.valueOf(cartService.getCount(account.getId())));
		model.addAttribute("totalCartAmount", String.valueOf(cartService.getTotalCartAmount(account.getId())));
		return "Cart";
	}
	@GetMapping("/subAmountCart")
	public String subAmountCart(@RequestParam("productID") int productId, @RequestParam("size") String size,
			HttpSession session) {
		Account account = (Account) session.getAttribute("acc");
		Integer accountId = account != null ? account.getId() : null;
		cartService.decreaseProductAmount(productId, size, accountId);
		return "redirect:/managerCart";
	}

	@GetMapping("/addAmountCart")
	public String addAmountCart(@RequestParam("productID") int productId, @RequestParam("size") String size,
			HttpSession session) {
		Account account = (Account) session.getAttribute("acc");
		Integer accountId = account != null ? account.getId() : null;
		cartService.increaseProductAmount(productId, size, accountId);
		return "redirect:/managerCart";
	}

	@GetMapping("/deleteCart")
	public String deleteCart(@RequestParam("productID") int productId, @RequestParam("size") String size,
			HttpSession session) {
		Account account = (Account) session.getAttribute("acc");
		Integer accountId = account != null ? account.getId() : null;
		cartService.removeProductFromCart(productId, size, accountId);
		return "redirect:/managerCart";
	}

}
