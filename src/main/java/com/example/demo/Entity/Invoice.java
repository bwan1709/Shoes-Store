package com.example.demo.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maHD;
	@ManyToOne
	@JoinColumn(name = "accountID")
	private Account account;
	private double tongGia;
	private Date ngayXuat;
	public String getAccountName() {
	    if (this.account != null) {
	        return this.account.getUsername();
	    } else {
	        return null; 
	    }
	}

}
