package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.SoLuongDaBan;
import com.example.demo.Repositories.SoLuongDaBanDAO;

@Service
public class SoLuongDaBanService {
    @Autowired
    private SoLuongDaBanDAO soLuongDaBanDAO;

    public List<SoLuongDaBan> getTop10SanPhamBanChayNhat() {
        return soLuongDaBanDAO.findTop10ByOrderBySoLuongDaBanDesc();
    }
}
