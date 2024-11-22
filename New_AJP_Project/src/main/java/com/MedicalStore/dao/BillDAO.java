package com.MedicalStore.dao;

import com.MedicalStore.HibernateUtil;
import com.MedicalStore.entities.Bill;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BillDAO {

    public boolean addBill(Bill bill) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(bill);
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

    public List<Bill> getAllBills() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Bill> query = session.createQuery("from Bill", Bill.class);
            return query.list();
        } finally {
            session.close();
        }
    }

    public Bill getBillById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Bill.class, id);
        } finally {
            session.close();
        }
    }

    public boolean updateBill(Bill bill) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(bill);
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

    public boolean deleteBill(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Bill bill = session.get(Bill.class, id);
            if (bill != null) {
                session.delete(bill);
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
