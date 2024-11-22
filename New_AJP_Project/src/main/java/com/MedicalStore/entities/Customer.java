package com.MedicalStore.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "customers") // This will create a table named "customers" in the database
public class Customer {

    // Instance variables
    @Id // This makes the field 'id' the primary key for this entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the primary key value
    @Column(name = "id") // Specify column name in the database
    private int id;

    @Column(name = "name", nullable = false) // Name of the customer
    private String name;

    @Column(name = "email", nullable = false, unique = true) // Email, should be unique and not null
    private String email;

    @Column(name = "phone", nullable = false) // Customer's phone number
    private String phone;

    // Default Constructor (Required by JPA for entity management)
    public Customer(String name2, String address, String phone2, String email2, Date dob) {
        // No-argument constructor is necessary for JPA to instantiate the object
    }

    // Parameterized Constructor (Custom constructor to initialize attributes)
    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Customer() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters for fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // toString method for debugging and logging purposes
    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "', email='" + email + "', phone='" + phone + "'}";
    }
}
