package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maCart;

	@ManyToOne
	@JoinColumn(name = "accountID")
	private Account account;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	private int amount;
	private String size;


	public double getTotal() {
		if (this.product != null) {
			return this.product.getPrice() * this.amount;
		} else {
			return 0.0;
		}
	}
}
