package com.MedicalStore.entities;

import javax.persistence.*;

@Entity
@Table(name = "sales_items") // The table name in the database will be "sales_items"
public class SalesItem {

    // Instance variables
    @Id // This marks 'id' as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the 'id' value for new records
    @Column(name = "id") // Column name in the database
    private int id;

    @ManyToOne // Many SalesItems can be associated with a single product
    @JoinColumn(name = "product_id", nullable = false) // Foreign key column linking to 'products' table
    private Product product;

    @ManyToOne // Many SalesItems can be associated with a single sale
    @JoinColumn(name = "sale_id", nullable = false) // Foreign key column linking to 'sales' table
    private Sales sale;

    @Column(name = "quantity", nullable = false) // Quantity of the product sold in this item
    private int quantity;

    @Column(name = "unit_price", nullable = false) // Price per unit of the product at the time of sale
    private double unitPrice;

    @Column(name = "total_price", nullable = false) // The total price for this sale item (quantity * unit price)
    private double totalPrice;

    // Default constructor (required by JPA)
    public SalesItem() {
        // No-argument constructor for JPA instantiation
    }

    // Parameterized constructor to initialize the SalesItem object
    public SalesItem(Product product, Sales sale, int quantity, double unitPrice) {
        this.product = product;
        this.sale = sale;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = calculateTotalPrice();
    }

    public SalesItem(Product selectedProduct, int quantity2) {
		// TODO Auto-generated constructor stub
	}

	// Method to calculate total price for the sales item (quantity * unitPrice)
    private double calculateTotalPrice() {
        return this.quantity * this.unitPrice;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sales getSale() {
        return sale;
    }

    public void setSale(Sales sale) {
        this.sale = sale;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalPrice = calculateTotalPrice(); // Recalculate total price whenever quantity changes
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        this.totalPrice = calculateTotalPrice(); // Recalculate total price whenever unit price changes
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "SalesItem{id=" + id + ", product=" + product.getProductName() + ", sale=" + sale.getSaleId() + ", quantity=" + quantity +
                ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + "}";
    }

	public void setProductId(int productId) {
		// TODO Auto-generated method stub
		
	}
}
