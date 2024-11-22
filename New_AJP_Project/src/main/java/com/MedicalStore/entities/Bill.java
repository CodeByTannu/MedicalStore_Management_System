package com.MedicalStore.entities;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bills")
public class Bill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment primary key
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    private Sales sale;  // Reference to the Sale entity

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SalesItem> salesItems;  // List of sales items related to this bill

    @Column(name = "total_amount")
    private double totalAmount;  // Total amount for the bill

    // Default constructor
    public Bill() {
    }

    // Constructor to initialize Bill with Sale, SalesItems, and Total Amount
    public Bill(Sales sale, List<SalesItem> salesItems, double totalAmount) {
        this.sale = sale;
        this.salesItems = salesItems;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters for all fields

    public Bill(Sales currentSale, double totalAmount2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sales getSale() {
        return sale;
    }

    public void setSale(Sales sale) {
        this.sale = sale;
    }

    public List<SalesItem> getSalesItems() {
        return salesItems;
    }

    public void setSalesItems(List<SalesItem> salesItems) {
        this.salesItems = salesItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // Method to calculate the total amount of the bill based on sales items
    public void calculateTotalAmount() {
        double total = 0;
        for (SalesItem item : salesItems) {
            total += item.getQuantity() * item.getUnitPrice();
        }
        this.totalAmount = total;
    }

    @Override
    public String toString() {
        return "Bill{id=" + id +
               ", sale=" + sale +
               ", totalAmount=" + totalAmount + '}';
    }

	public void setBillDate(Date date) {
		// TODO Auto-generated method stub
		
	}
}
