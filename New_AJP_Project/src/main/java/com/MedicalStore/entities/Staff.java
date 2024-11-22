package com.MedicalStore.entities;

import javax.persistence.*;

@Entity
@Table(name = "Staff")
public class Staff {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private int staffId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    public Staff(String username, String password) {
        this.username = username;
        this.password = password;
    }

	public Staff() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

	public void setEmail1(String email2) {
		// TODO Auto-generated method stub
		
	}
}
