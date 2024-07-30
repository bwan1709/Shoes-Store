package com.example.demo.Entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Product")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String image;
	private double price;
	private String title;
	@Column(length = 1000)
	private String description;

	@ManyToOne
	@JoinColumn(name = "Cateid")
	private Category category; // Renamed to 'category' to match with the attribute name in Category class

	@ManyToOne
	@JoinColumn(name = "sell_ID")
	private Account sell_ID;
	private String model;
	private String color;
	private String delivery;
	private String image2;
	private String image3;
	private String image4;

	@Override
	public String toString() {
		return "Product{id=" + id + ", name='" + name + "', price=" + price + ", ...}";
	}

	private String brand; // Add this field
	// Getters and setters
}
