package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.Product;
import com.example.demo.Repositories.CategoryDAO;
import com.example.demo.Repositories.ProductDAO;

@Controller
public class ShopController {
	@Autowired
	CategoryDAO ctDao;
	@Autowired
	ProductDAO productDao;

	@GetMapping("/shop")
	public String shop(Model model, @RequestParam(value = "p", defaultValue = "0") int currentPage,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "priceRange", required = false) String priceRange,
			@RequestParam(value = "priceMin", required = false) Double priceMin,
			@RequestParam(value = "priceMax", required = false) Double priceMax) {
		int pageSize = 6; // Số lượng sản phẩm trên mỗi trang
		List<Category> listCC = ctDao.findAll();
		model.addAttribute("listCC", listCC);

		Pageable pageable = PageRequest.of(currentPage, pageSize);
		Page<Product> page;

		// Kiểm tra xem có từ khóa tìm kiếm không
		if (search != null && !search.isEmpty()) {
			// Nếu có từ khóa tìm kiếm
			if (priceMin != null && priceMax != null) {
				// Nếu có cả giá tối thiểu và tối đa được cung cấp
				page = productDao.findByNameContainingIgnoreCaseAndPriceBetween(search, priceMin, priceMax, pageable);
			} else if (priceRange != null && !priceRange.isEmpty()) {
				// Nếu chỉ có phạm vi giá được chọn
				switch (priceRange) {
				case "under100":
					page = productDao.findByNameContainingIgnoreCaseAndPriceLessThan(search, 100, pageable);
					break;
				case "100to200":
					page = productDao.findByNameContainingIgnoreCaseAndPriceBetween(search, 100, 200, pageable);
					break;
				case "above200":
					page = productDao.findByNameContainingIgnoreCaseAndPriceGreaterThanEqual(search, 200, pageable);
					break;
				default:
					page = productDao.findByNameContainingIgnoreCase(search, pageable);
					break;
				}
			} else {
				// Nếu chỉ có từ khóa tìm kiếm
				page = productDao.findByNameContainingIgnoreCase(search, pageable);
			}
		} else if (priceRange != null && !priceRange.isEmpty()) {
			// Nếu có phạm vi giá được chọn
			switch (priceRange) {
			case "under100":
				page = productDao.findByPriceLessThan(100, pageable);
				break;
			case "100to200":
				page = productDao.findByPriceBetween(100, 200, pageable);
				break;
			case "above200":
				page = productDao.findByPriceGreaterThanEqual(200, pageable);
				break;
			default:
				page = productDao.findAll(pageable);
				break;
			}
		} else if (priceMin != null && priceMax != null) {
			// Nếu chỉ có giá tối thiểu và tối đa được cung cấp
			page = productDao.findByPriceBetween(priceMin, priceMax, pageable);
		} else {
			// Nếu không có yêu cầu tìm kiếm cụ thể
			page = productDao.findAll(pageable);
		}

		model.addAttribute("page", page);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", page.getTotalPages());

		return "Shop";
	}

}
