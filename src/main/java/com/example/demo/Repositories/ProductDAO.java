package com.example.demo.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

import com.example.demo.Entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {
//	@Query("SELECT p FROM Product p ORDER BY p.id DESC")
//	List<Product> findLatestProducts();
//
//	@Query("SELECT p FROM Product p WHERE p.model = 'Nike' ORDER BY p.id DESC")
//	List<Product> findLatestNikeProducts();
//
//	@Query("SELECT p FROM Product p WHERE p.model = 'Adidas' ORDER BY p.id DESC")
//	List<Product> findLatestAdidasProducts();

	// Sửa lại truy vấn để sử dụng thuộc tính cateID
	@Query("SELECT p FROM Product p WHERE p.category.id = ?1")
	List<Product> findByCategoryId(int categoryId);
	List<Product> findByName(String name);
	List<Product> findByNameContaining(String name);
//	Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Product> findByNameContainingIgnoreCaseAndPriceBetween(String name, Double priceMin, Double priceMax, Pageable pageable);
    Page<Product> findByNameContainingIgnoreCaseAndPriceLessThan(String name, double price, Pageable pageable);

    Page<Product> findByNameContainingIgnoreCaseAndPriceBetween(String name, double minPrice, double maxPrice, Pageable pageable);

    // Tìm sản phẩm theo tên chứa từ khóa (không phân biệt hoa thường) và giá lớn hơn hoặc bằng một ngưỡng
    Page<Product> findByNameContainingIgnoreCaseAndPriceGreaterThanEqual(String name, double price, Pageable pageable);

    // Tìm sản phẩm theo tên chứa từ khóa (không phân biệt hoa thường)
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

//	List<Product> findByPriceLessThan(float price);
//
//	List<Product> findByPriceGreaterThan(float price);

	List<Product> findByColor(String color);

	Page<Product> findByPriceLessThan(double price, Pageable pageable);

	Page<Product> findByPriceBetween(double minPrice, double maxPrice, Pageable pageable);

	Page<Product> findByPriceGreaterThanEqual(double price, Pageable pageable);

	// Thêm phương thức để lấy danh sách sản phẩm theo trang
	@Query("SELECT p FROM Product p")
	List<Product> findProductsByPage(int pageIndex);

	// Thêm phương thức để đếm tổng số sản phẩm
	@Query("SELECT COUNT(p) FROM Product p")
	int countAllProducts();
	List<Product> findTop8ByOrderByIdDesc();
}
