package com.MedicalStore.dao;

import com.MedicalStore.entities.Admin;
import com.MedicalStore.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminDAO {

    public Admin getAdminByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Admin admin = null;
        try {
            admin = session.createQuery("FROM Admin WHERE username = :username", Admin.class)
                           .setParameter("username", username)
                           .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return admin;
    }

    public boolean addAdmin(Admin admin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(admin);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }
}
