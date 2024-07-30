package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.SoLuongDaBan;


@Repository
public interface SoLuongDaBanDAO extends JpaRepository<SoLuongDaBan, Integer> {
    // Các phương thức truy vấn tùy chỉnh có thể được định nghĩa ở đây nếu cần
	List<SoLuongDaBan> findTop10ByOrderBySoLuongDaBanDesc();
}
