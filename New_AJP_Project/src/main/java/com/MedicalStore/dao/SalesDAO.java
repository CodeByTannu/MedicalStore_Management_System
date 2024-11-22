package com.MedicalStore.dao;

import com.MedicalStore.HibernateUtil;
import com.MedicalStore.entities.Sales;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SalesDAO {

    public boolean addSale(Sales sales) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(sales);
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

    public List<Sales> getAllSales() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Sales> query = session.createQuery("from Sales", Sales.class);
            return query.list();
        } finally {
            session.close();
        }
    }

    public Sales getSaleById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Sales.class, id);
        } finally {
            session.close();
        }
    }

    public boolean updateSale(Sales sales) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(sales);
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

    public boolean deleteSale(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Sales sales = session.get(Sales.class, id);
            if (sales != null) {
                session.delete(sales);
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
