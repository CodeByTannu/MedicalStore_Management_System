package com.MedicalStore;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.MedicalStore.dao.SalesDAO;
import com.MedicalStore.entities.Admin;
import com.MedicalStore.entities.Bill;
import com.MedicalStore.entities.Customer;
import com.MedicalStore.entities.Product;
import com.MedicalStore.entities.Sales;
import com.MedicalStore.entities.SalesItem;
import com.MedicalStore.entities.Staff;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
                    .addAnnotatedClass(Sales.class)
                    .addAnnotatedClass(SalesItem.class)
                    .addAnnotatedClass(Bill.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Admin.class)
                    .addAnnotatedClass(Staff.class)
                    .addAnnotatedClass(SalesDAO.class)
                    .buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}

