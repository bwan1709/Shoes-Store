package com.example.demo.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.Invoice;
import com.example.demo.Repositories.InvoiceDAO;
import com.example.demo.helper.InvoiceExcelExporter;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ExcelController {
	@Autowired
	InvoiceDAO invoiceDao;
	
	@PostMapping("/admin/xuatHoaDon")
	public String exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=invoices_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<Invoice> listInvoice = invoiceDao.findAll();	
		System.out.println(listInvoice);
		InvoiceExcelExporter excelExporter = new InvoiceExcelExporter(listInvoice);
		excelExporter.export(response);
		return "/admin/hoaDon";
	}
}
