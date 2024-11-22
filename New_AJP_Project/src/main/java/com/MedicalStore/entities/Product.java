package com.MedicalStore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "unit_price", nullable = false)
    private double unitPrice;

    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;

    // Default Constructor
    public Product() {
    }

    // Parameterized Constructor
    public Product(String productName, String productDescription, double unitPrice, int stockQuantity) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }

    public Product(String name, String brand, String genericName, String category, int stockQuantity2,
			double purchasePrice, double salePrice, Date expiryDate) {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // Override toString method for easy representation of the product object
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + productName + ", description=" + productDescription +
                ", unitPrice=" + unitPrice + ", stockQuantity=" + stockQuantity + "]";
    }

}