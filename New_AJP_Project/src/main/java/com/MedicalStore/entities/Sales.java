package com.MedicalStore.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private int saleId;

    public Sales(int saleId, Staff staff, Customer customer, Date saleDate, double totalAmount) {
		super();
		this.saleId = saleId;
		this.staff = staff;
		this.customer = customer;
		this.saleDate = saleDate;
		this.totalAmount = totalAmount;
	}


	@ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "sale_date")
    @Temporal(TemporalType.DATE)
    private Date saleDate;

    @Column(name = "total_amount")
    private double totalAmount;

    // Constructors
    public Sales() {
        // Default constructor
    }

    // Getters and Setters
    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

	
	public void addSalesItem(SalesItem saleItem) {
		// TODO Auto-generated method stub
		
	}
}
