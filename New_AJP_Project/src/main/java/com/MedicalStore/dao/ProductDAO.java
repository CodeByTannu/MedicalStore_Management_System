package com.MedicalStore.dao;

import com.MedicalStore.HibernateUtil;
import com.MedicalStore.entities.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class ProductDAO {

    public boolean addProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public List<Product> getAllProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Product> query = session.createQuery("from Product", Product.class);
            return query.list();
        } finally {
            session.close();
        }
    }

    public Product getProductById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Product.class, id);
        } finally {
            session.close();
        }
    }

    public boolean updateProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteProduct(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Product product = session.get(Product.class, id);
            if (product != null) {
                session.delete(product);
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
