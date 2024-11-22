package com.MedicalStore.dao;

import com.MedicalStore.HibernateUtil;
import com.MedicalStore.entities.SalesItem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SalesItemDAO {

    public boolean addSalesItem(SalesItem salesItem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(salesItem);
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

    public List<SalesItem> getAllSalesItems() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<SalesItem> query = session.createQuery("from SalesItem", SalesItem.class);
            return query.list();
        } finally {
            session.close();
        }
    }

    public SalesItem getSalesItemById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(SalesItem.class, id);
        } finally {
            session.close();
        }
    }

    public boolean updateSalesItem(SalesItem salesItem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(salesItem);
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

    public boolean deleteSalesItem(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            SalesItem salesItem = session.get(SalesItem.class, id);
            if (salesItem != null) {
                session.delete(salesItem);
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
