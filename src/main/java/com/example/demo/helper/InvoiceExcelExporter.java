package com.example.demo.helper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 

 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.Entity.Invoice;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
 
public class InvoiceExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Invoice> listInvoices;
     
    public InvoiceExcelExporter(List<Invoice> listInvoices) {
        this.listInvoices = listInvoices;
        workbook = new XSSFWorkbook();
    }
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Invoices");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "Mã Hóa Đơn", style);      
        createCell(row, 1, "Account", style);       
        createCell(row, 2, "Tổng giá", style); 
        createCell(row, 3, "Ngày xuất", style);  
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        Cell cell = row.createCell(columnCount);
        if (value == null) {
            cell.setCellValue("");
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Date) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày tháng bạn muốn
            cell.setCellValue(dateFormat.format((Date) value));
        } else {
            cell.setCellValue(value.toString());
        }
        cell.setCellStyle(style);
        sheet.autoSizeColumn(columnCount);
    }

     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Invoice invoice : listInvoices) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, invoice.getMaHD(), style);
            createCell(row, columnCount++, invoice.getAccountName(), style);
            createCell(row, columnCount++, invoice.getTongGia(), style);
            createCell(row, columnCount++, invoice.getNgayXuat(), style);
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();     
        outputStream.close();
    }
}
