package com.barbershop.manager_barbershop.DAO.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.barbershop.manager_barbershop.DAO.ICustomerDAO;
import com.barbershop.manager_barbershop.DTO.CustomerDTO;
import com.barbershop.manager_barbershop.config.HibernateUtil;
import com.barbershop.manager_barbershop.entity.CustomerEntity;

public class CustomerDAO extends AbstractDao<CustomerEntity, CustomerDTO> implements ICustomerDAO {

	@Override
	public Long saveEntity(CustomerEntity object) {

		return save(object);
	}

	@Override
	public CustomerEntity findById(Long id) {
		
		CustomerEntity customer = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String sql = "FROM CustomerEntity c WHERE c.id = ?1";
			Query query = session.createQuery(sql);
			query.setParameter(1, id);
			List<CustomerEntity> result = query.list();
			customer = result.get(0);

//			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public CustomerEntity findByUserName(String userName) {
		CustomerEntity customer = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String sql = "FROM CustomerEntity c WHERE c.userName = ?1";
			Query query = session.createQuery(sql);
			query.setParameter(1, userName);
			List<CustomerEntity> result = query.list();
			customer = result.get(0);

//			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public int count() {
		int total = 0;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String sql = "SELECT count(*) FROM CustomerEntity";
			Query query = session.createQuery(sql);
			
			List<Integer> result = query.list();
			total = result.get(0);

//			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return total;
	}

}
