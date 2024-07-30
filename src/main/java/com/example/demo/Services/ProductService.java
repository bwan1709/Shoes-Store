package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repositories.ProductDAO;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
}
