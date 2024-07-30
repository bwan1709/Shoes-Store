package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.TongChiTieuBanHang;
import com.example.demo.Repositories.TongChiTieuBanHangDAO;

@Service
public class TongChiTieuBanHangService {
	@Autowired
	private TongChiTieuBanHangDAO tongChiTieuBanHangDAO;

	public List<TongChiTieuBanHang> getAllTongChiTieuBanHang() {
		return tongChiTieuBanHangDAO.findAll();
	}

	public List<Object[]> findTop5OutstandingSalespersons() {
		return tongChiTieuBanHangDAO.findTop5OutstandingSalespersons();
	}
}
