package com.example.demo.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Invoice;

@Repository
public interface InvoiceDAO extends JpaRepository<Invoice, Integer> {
	// Các phương thức truy vấn tùy chỉnh có thể được định nghĩa ở đây nếu cần
//	@Query("SELECT SUM(i.tong_gia) FROM Invoice i WHERE MONTH(i.ngay_xuat) = :month")
//	Double totalMoneyMonth(@Param("month") int month);
	List<Invoice> findByNgayXuatBetween(java.sql.Timestamp startDate, java.sql.Timestamp endDate);

	default List<Invoice> findByNgayXuat(LocalDate date) {
		java.sql.Timestamp startOfDay = java.sql.Timestamp.valueOf(date.atStartOfDay());
		java.sql.Timestamp endOfDay = java.sql.Timestamp.valueOf(date.atTime(23, 59, 59));
		return findByNgayXuatBetween(startOfDay, endOfDay);
	}
}
