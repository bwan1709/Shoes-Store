package com.example.demo.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maReview;

	@ManyToOne
	@JoinColumn(name = "accountID")
	private Account account;

	@ManyToOne
	@JoinColumn(name = "productID")
	private Product product;

	private String contentReview;
	private Date dateReview;

	// Getters and setters
}
