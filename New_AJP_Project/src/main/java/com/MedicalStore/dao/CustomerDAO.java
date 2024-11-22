package com.MedicalStore.dao;

import com.MedicalStore.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CustomerDAO {

    private SessionFactory factory;

    public CustomerDAO() {
        // Initialize the Hibernate session factory
        this.factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
    }

    // Add a new customer to the database
    public boolean addCustomer(Customer customer) {
        Session session = factory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(customer);  // Save the customer object to the database
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback if any exception occurs
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();  // Close the session after use
        }
    }

    // Update customer details
    public boolean updateCustomer(Customer customer) {
        Session session = factory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(customer);  // Update the customer in the database
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback if any exception occurs
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();  // Close the session after use
        }
    }

    // Delete customer from the database by ID
    public boolean deleteCustomer(int id) {
        Session session = factory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, id);  // Retrieve the customer by ID
            if (customer != null) {
                session.delete(customer);  // Delete the customer if found
                transaction.commit();
                return true;
            } else {
                return false;  // Return false if customer is not found
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback if any exception occurs
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();  // Close the session after use
        }
    }

    // Retrieve a customer by ID
    public Customer getCustomerById(int id) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);  // Retrieve customer by ID
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();  // Close the session after use
        }
    }

    // Get all customers from the database
    public List<Customer> getAllCustomers() {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Query<Customer> query = session.createQuery("from Customer", Customer.class);  // HQL query to get all customers
            List<Customer> customers = query.getResultList();  // Execute query and get list of customers
            return customers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();  // Close the session after use
        }
    }
}
