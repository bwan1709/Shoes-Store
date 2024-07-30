package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.domain.Pageable;

import com.example.demo.Entity.Account;
import com.example.demo.Entity.Category;
import com.example.demo.Entity.Invoice;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.SoLuongDaBan;
import com.example.demo.Entity.Supplier;
import com.example.demo.Repositories.AccountDAO;
import com.example.demo.Repositories.CategoryDAO;
import com.example.demo.Repositories.ProductDAO;
import com.example.demo.Repositories.SupplierDAO;
import com.example.demo.Services.AccountService;
import com.example.demo.Services.InvoiceService;
import com.example.demo.Services.SoLuongDaBanService;
import com.example.demo.Services.TongChiTieuBanHangService;

@Controller
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
public class AdminController {
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private SoLuongDaBanService soLuongDaBanService;
	@Autowired
	private TongChiTieuBanHangService tongChiTieuBanHangService;
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private AccountDAO accountDAO;
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	@GetMapping("/admin")
	public String admin(Model model) {
		List<Account> listA = accountDAO.findAll();
		model.addAttribute("listA", listA);
		return "admin/QuanLyTaiKhoan";
	}
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	@GetMapping("/admin/manager")
	public String manager(Model model, @RequestParam(defaultValue = "1") int page) {
		Pageable pageable = PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "id"));
		Page<Product> productPage = productDAO.findAll(pageable);
		int totalPages = productPage.getTotalPages();
		List<Product> listP = productPage.getContent();
		model.addAttribute("listP", listP);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);

		List<Category> listCC = categoryDAO.findAll();
		model.addAttribute("listCC", listCC);

		return "admin/QuanLySanPham";
	}
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	@PostMapping("/admin/addProduct")
	public String addProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
		productDAO.save(product);
		redirectAttributes.addFlashAttribute("mess", "Thêm sản phẩm thành công!");
		return "redirect:/admin/manager";
	}
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	@GetMapping("/admin/delete")
	public String deleteProduct(@RequestParam("pid") Integer id, RedirectAttributes redirectAttributes) {
		try {
			productDAO.deleteById(id);
			redirectAttributes.addFlashAttribute("mess", "Xóa sản phẩm thành công!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Không thể xóa sản phẩm!");
		}
		return "redirect:/admin/manager";
	}
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	@GetMapping("/admin/loadProduct")
	public String loadProduct(@RequestParam("pid") Integer id, Model model) {
		Product product = productDAO.findById(id).orElse(null);
		if (product == null) {
			model.addAttribute("error", "Sản phẩm không tồn tại!");
			return "redirect:/admin/manager";
		}
		model.addAttribute("detail", product);
		List<Category> listCC = categoryDAO.findAll();
		model.addAttribute("listCC", listCC);
		return "admin/Edit";
	}
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	@PostMapping("/admin/updateProduct")
	public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
		productDAO.save(product);
		redirectAttributes.addFlashAttribute("mess", "Cập nhật sản phẩm thành công!");
		return "redirect:/admin/manager";
	}
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	@GetMapping("/admin/managerSupplier")
	public String managerSupplier(Model model) {
		List<Supplier> listAllSupplier = supplierDAO.findAll();
		List<Category> listAllCategory = categoryDAO.findAll();
		model.addAttribute("listAllSupplier", listAllSupplier);
		model.addAttribute("listAllCategory", listAllCategory);
		return "admin/NhaPhanPhoi";
	}
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	@GetMapping("/admin/deleteSupplier")
	public String deleteSupplier(@RequestParam("id") int idSupplier, RedirectAttributes redirectAttributes) {
		supplierDAO.deleteById(idSupplier);
		// Redirect to managerSupplier page with a success message
		redirectAttributes.addFlashAttribute("mess", "xóa nhà cung cấp thành công!");
		return "redirect:/admin/managerSupplier";
	}
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	@PostMapping("/admin/addSupplier")
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier, RedirectAttributes redirectAttributes) {
		supplierDAO.save(supplier);
		redirectAttributes.addFlashAttribute("mess", "Thêm nhà cung cấp thành công!");
		return "redirect:/admin/managerSupplier";
	}
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	@GetMapping("/admin/managerAccount")
	public String managerAccount(Model model) {
		List<Account> listA = accountDAO.findAll();
		model.addAttribute("listA", listA);
		return "admin/QuanLyTaiKhoan";
	}
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	@PostMapping("/admin/addAccount")
	public String addAccount(@ModelAttribute Account account, RedirectAttributes redirectAttributes) {
		accountDAO.save(account);
		redirectAttributes.addFlashAttribute("mess", "Thêm tài khoản thành công!");
		return "redirect:/admin/managerAccount";
	}
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	@GetMapping("/admin/deleteAccount")
	public String deleteAccount(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			accountDAO.deleteById(id);
			redirectAttributes.addFlashAttribute("mess", "Xóa tài khoản thành công!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Không thể xóa tài khoản!");
		}
		return "redirect:/admin/managerAccount";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin/top10")
	public String top10(Model model) {
		List<SoLuongDaBan> top10SanPhamBanChay = soLuongDaBanService.getTop10SanPhamBanChayNhat();
		model.addAttribute("listTop10Product", top10SanPhamBanChay);
		return "admin/Top10SanPhamBanChay";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin/top5khachhang")
	public String top5KhachHang(Model model) {
		List<Object[]> listTop5KhachHang = accountService.getTop5AccountsByTotalSpending();
		model.addAttribute("listTop5KhachHang", listTop5KhachHang);
		return "admin/Top5KhachHang";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin/top5nhanvien")
	public String top5nhanvien(Model model) {
		List<Object[]> listTop5NhanVien = tongChiTieuBanHangService.findTop5OutstandingSalespersons();
		model.addAttribute("listTop5NhanVien", listTop5NhanVien);
		return "admin/Top5NhanVien";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin/doanhThuTheoThu")
	public String doanhThuTheoThu() {
		return "redirect:/admin";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin/doanhThuTheoThang")
	public String doanhThuTheoThang(Model model) {
//        // Lấy tổng doanh thu của các tháng từ tháng 1 đến tháng 12
//        List<Double> totalRevenueByMonth = new ArrayList<>();
//        for (int i = 1; i <= 12; i++) {
//            Double totalMoney = invoiceService.getTotalRevenueByMonth(i);
//            totalRevenueByMonth.add(totalMoney != null ? totalMoney : 0.0);
//        }
//        model.addAttribute("totalRevenueByMonth", totalRevenueByMonth);
		return "admin/DoanhThuTheoThang";
	}
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	@GetMapping("/admin/hoaDon")
	public String hoaDon(Model model) {
		List<Invoice> listAllInvoice = invoiceService.getAllInvoices();
		model.addAttribute("listAllInvoice", listAllInvoice);
		return "admin/HoaDon";
	}
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
	@PostMapping("/admin/hoaDon")
	public String hoaDonByDate(@RequestParam("dateHoaDon") String ngayXuat, Model model) {
		LocalDate date;
		if (ngayXuat == null || ngayXuat.isEmpty()) {
			List<Invoice> listAllInvoice = invoiceService.getAllInvoices();
			model.addAttribute("listAllInvoice", listAllInvoice);
		} else {
			date = LocalDate.parse(ngayXuat);
			List<Invoice> listAllInvoiceByDate = invoiceService.getInvoicesByDate(date);
			model.addAttribute("listAllInvoice", listAllInvoiceByDate);
		}
		return "admin/HoaDon";
	}

	@GetMapping("/hoaDon")
	public String hoaDon1() {
		return "redirect:/admin/hoaDon";
	}

}
