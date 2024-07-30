package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.DTO.CartItemDTO;
import com.example.demo.Entity.Account;
import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Invoice;
import com.example.demo.Repositories.AccountDAO;
import com.example.demo.Repositories.InvoiceDAO;
import com.example.demo.Services.CartService;
import com.example.demo.Services.InvoiceService;
import com.example.demo.Services.SessionService;

@Controller
public class OrderController {
	@Autowired
	CartService cartService;
	@Autowired
	AccountDAO accountDao;
	@Autowired
	SessionService session;
	@Autowired
	InvoiceDAO invoiceDao;

	@PostMapping("/order")
	public String checkout(@RequestParam("address") String address, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("phoneNumber") String phoneNumber, Model model) {
		Account account = (Account) session.get("acc");
		Integer accountId = (account != null) ? account.getId() : null;

		List<Cart> listCart = cartService.getAllCartItems();
		double totalAmount = cartService.getTotalCartAmount(accountId);

		List<CartItemDTO> cartItems = new ArrayList<>();
		for (Cart cart : listCart) {
			CartItemDTO cartItemDTO = new CartItemDTO();
			cartItemDTO.setProductName(cart.getProduct().getName());
			cartItemDTO.setQuantity(cart.getAmount());
			cartItemDTO.setPrice(cart.getProduct().getPrice());
			cartItems.add(cartItemDTO);
		}
		model.addAttribute("address", address);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phoneNumber", phoneNumber);
		model.addAttribute("cartItems", cartItems);
		model.addAttribute("totalCartAmount", totalAmount);
		return "ThongTinDatHang";
	}

	@GetMapping("/order")
	public String order() {
		return "DatHang";
	}

	@PostMapping("/confirmOrder")
	public String confirmOrder(Model model) {
		Account account = (Account) session.get("acc");
		Integer accountId = (account != null) ? account.getId() : null;
		Invoice invoice = new Invoice();
		invoice.setNgayXuat(new Date());
		if (accountId != null) {
			invoice.setAccount(account);
			invoice.setTongGia(cartService.getTotalCartAmount(accountId));
			// Lưu hóa đơn vào cơ sở dữ liệu
			invoiceDao.save(invoice);
			// Xóa các mục trong giỏ hàng của tài khoản này
			cartService.deleteByAccountId(accountId);
		} else {
			// Nếu không có tài khoản, chỉ cập nhật tổng giá của hóa đơn
			invoice.setTongGia(cartService.getTotalCartAmount(null));
			// Lưu hóa đơn vào cơ sở dữ liệu
			invoiceDao.save(invoice);
			// Xóa tất cả các mục trong giỏ hàng (nếu accountId là null)
			cartService.deleteByAccountId(null);
		}
		model.addAttribute("message", "Đơn hàng đã được xác nhận và giỏ hàng đã được xóa.");
		return "orderSuccess";
	}

}
