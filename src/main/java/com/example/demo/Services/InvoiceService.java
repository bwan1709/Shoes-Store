package com.example.demo.Services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Invoice;
import com.example.demo.Repositories.InvoiceDAO;

@Service
public class InvoiceService {
	@Autowired
	private InvoiceDAO invoiceDAO;

	public List<Invoice> getAllInvoices() {
		return invoiceDAO.findAll();
	}

	public List<Invoice> getInvoicesByDate(LocalDate date) {
		return invoiceDAO.findByNgayXuat(date);
	}
	
	
}
