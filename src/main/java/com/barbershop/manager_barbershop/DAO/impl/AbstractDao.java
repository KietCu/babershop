package com.barbershop.manager_barbershop.DAO.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.barbershop.manager_barbershop.DAO.GenericDao;
import com.barbershop.manager_barbershop.config.HibernateUtil;
import com.barbershop.manager_barbershop.entity.CustomerEntity;
import com.barbershop.manager_barbershop.mapper.rowMapper;

public class AbstractDao<T, K> implements GenericDao<T, K> {

	@Override
	public List<K> query(String sql, rowMapper<T, K> rowmap, Object... para) {
		List<K> results = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Query query = session.createQuery(sql);
			setParameter(query, para);
			List<T> result = query.list();
			if(result.size() > 0) {
				results = rowmap.mapper(result);
			}
			

//			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return results;
	}

	private void setParameter(Query statement, Object... para) throws SQLException {
		if(para == null) {
			return;
		}
		for (int i = 0; i < para.length; i++) {
			Object parameter = para[i];
			
			int index = i + 1;
			if (parameter instanceof String) {
				statement.setParameter(index, (String) parameter);
			} else if (parameter instanceof Integer) {
				statement.setParameter(index, (int) parameter);
			} else if (parameter instanceof Long) {
				statement.setParameter(index, (long) parameter);
			}
		}

	}

	@Override
	public Long save(T object) {
		Long result = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			result = (Long) session.save(object);
			System.out.println(result);

			// Check if the transaction is still active.
			session.flush();
			transaction.commit();


			session.close();
			return result;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void update(T object) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			session.saveOrUpdate(object);
			session.flush();
			session.close();
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	@Override
	public int countTheItem(String sql, Object... para) {
		// TODO Auto-generated method stub
		return 0;
	}

}
