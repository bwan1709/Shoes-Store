package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.TongChiTieuBanHang;


@Repository
public interface TongChiTieuBanHangDAO extends JpaRepository<TongChiTieuBanHang, Integer> {
    // Các phương thức truy vấn tùy chỉnh có thể được định nghĩa ở đây nếu cần
	@Query("SELECT a.id AS ID, a.username AS Username, a.email AS Email, SUM(tc.tongBanHang) AS tongBanHang "
			+ "FROM Account a " + "JOIN TongChiTieuBanHang tc ON a.id = tc.user.id "
			+ "GROUP BY a.id, a.username, a.email " + "ORDER BY tongBanHang DESC")
	List<Object[]> findTop5OutstandingSalespersons();
}