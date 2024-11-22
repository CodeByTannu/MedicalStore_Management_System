package com.MedicalStore.Service;

import java.util.List;

import com.MedicalStore.dao.CustomerDAO;
import com.MedicalStore.entities.Customer;

public class CustomerService {

    private CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
    }

    // Retrieve customer by ID
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    // Add a new customer
    public boolean addCustomer(Customer customer) {
        return customerDAO.addCustomer(customer);
    }

    // Update customer details
    public boolean updateCustomer(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }

    // Delete customer by ID
    public boolean deleteCustomer(int id) {
        return customerDAO.deleteCustomer(id);
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }
}
