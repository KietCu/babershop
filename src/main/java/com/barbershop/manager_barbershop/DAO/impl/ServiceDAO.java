package com.barbershop.manager_barbershop.DAO.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.barbershop.manager_barbershop.DAO.IServiceDAO;
import com.barbershop.manager_barbershop.DTO.ServiceDTO;
import com.barbershop.manager_barbershop.config.HibernateUtil;
import com.barbershop.manager_barbershop.entity.CustomerEntity;
import com.barbershop.manager_barbershop.entity.ServiceEntity;
import com.barbershop.manager_barbershop.mapper.rowMapper;
import com.barbershop.manager_barbershop.mapper.impl.ServiceMapper;

public class ServiceDAO extends AbstractDao<ServiceEntity, ServiceDTO> implements IServiceDAO {

	@Override
	public long saveEntity(ServiceEntity service) {
		
		return save(service);
	}

	@Override
	public List<ServiceDTO> findAll() {
		String sql = "FROM ServiceEntity";
		rowMapper<ServiceEntity, ServiceDTO> mapper = new ServiceMapper();
		return query(sql, mapper, null);
	}

	@Override
	public ServiceEntity findByTenDv(String text) {
		ServiceEntity service = null;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String sql = "FROM ServiceEntity c WHERE c.tenDv= ?1";
			Query query = session.createQuery(sql);
			query.setParameter(1, text);
			List<ServiceEntity> result = query.list();
			service = result.get(0);

//			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return service;
	}

}
