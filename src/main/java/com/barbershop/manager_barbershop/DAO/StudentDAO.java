package com.barbershop.manager_barbershop.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.barbershop.manager_barbershop.Student;
import com.barbershop.manager_barbershop.config.HibernateUtil;



public class StudentDAO {
	public void saveStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.persist(student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List < Student > getStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
    }
}
