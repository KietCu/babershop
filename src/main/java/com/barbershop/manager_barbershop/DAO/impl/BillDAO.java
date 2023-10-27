package com.barbershop.manager_barbershop.DAO.impl;

import java.util.Date;
import java.util.List;

import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.barbershop.manager_barbershop.DAO.IBillDao;
import com.barbershop.manager_barbershop.DTO.BillDTO;
import com.barbershop.manager_barbershop.config.HibernateUtil;
import com.barbershop.manager_barbershop.entity.AppointmentEntity;
import com.barbershop.manager_barbershop.entity.BillEntity;
import com.barbershop.manager_barbershop.mapper.rowMapper;
import com.barbershop.manager_barbershop.mapper.impl.BillMapper;

public class BillDAO extends AbstractDao<BillEntity, BillDTO> implements IBillDao {

	@Override
	public long saveEntity(BillEntity bill) {
		return save(bill);
	}

	@Override
	public List<BillDTO> findAllByCreateDate(String date) {
		String sql = "FROM BillEntity c WHERE c.createdDate = ? 1";
		rowMapper<BillEntity, BillDTO> mapper = new BillMapper();
		return query(sql, mapper, date);
	}

	@Override
	public void updateBill(Long idBill, double phiDichVu) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String sql = "FROM BillEntity c WHERE c.id = ?1";
			Query query = session.createQuery(sql);

			query.setParameter(1, idBill);

			BillEntity result = (BillEntity) query.uniqueResult();
			result.setTotal(phiDichVu);

			session.flush();
//			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	@Override
	public List<BillDTO> findByCustomerSdt(int sdt) {
		String sql = "FROM BillEntity c WHERE c.customers.sdt = ? 1";
		rowMapper<BillEntity, BillDTO> mapper = new BillMapper();
		return query(sql, mapper, sdt);
	}

	@Override
	public void remove(Long idBill) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String sql = "FROM BillEntity c WHERE c.id = ?1";
			Query query = session.createQuery(sql);

			query.setParameter(1, idBill);
			BillEntity bill = (BillEntity) query.uniqueResult();
			session.remove(bill);
			session.flush();
			transaction.commit();
			

			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

}
