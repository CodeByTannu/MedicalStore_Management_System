package com.MedicalStore.dao;

import com.MedicalStore.entities.Staff;
import com.MedicalStore.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StaffDAO {

    public Staff getStaffByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Staff staff = null;
        try {
            staff = session.createQuery("FROM Staff WHERE username = :username", Staff.class)
                           .setParameter("username", username)
                           .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return staff;
    }

    public boolean addStaff(Staff staff) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(staff);
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
