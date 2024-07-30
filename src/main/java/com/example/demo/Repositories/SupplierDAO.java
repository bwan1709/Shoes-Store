package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Supplier;

@Repository
public interface SupplierDAO extends JpaRepository<Supplier, Integer> {
    // Các phương thức truy vấn tùy chỉnh có thể được định nghĩa ở đây nếu cần
}
