package com.barbershop.manager_barbershop.DAO.impl;



import java.util.List;

import javax.swing.JComboBox;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.barbershop.manager_barbershop.DAO.IAppointmentDAO;
import com.barbershop.manager_barbershop.DTO.Appointment;
import com.barbershop.manager_barbershop.config.HibernateUtil;
import com.barbershop.manager_barbershop.entity.AppointmentEntity;
import com.barbershop.manager_barbershop.mapper.rowMapper;
import com.barbershop.manager_barbershop.mapper.impl.AppointmentMapper;

public class AppointmentDAO extends AbstractDao<AppointmentEntity, Appointment>  implements IAppointmentDAO{

	@Override
	public Long saveEntity(AppointmentEntity object) {
		return save(object);
	}

	@Override
	public List<Appointment> findAll(String date) {
		String hql = "FROM AppointmentEntity c WHERE c.ngayDat = ?1";
		rowMapper<AppointmentEntity, Appointment> rowmap = new AppointmentMapper();
		return query(hql, rowmap, date);
	}

	@Override
	public List<Appointment> findByNgayDat(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeById(Long idSelected) {
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	        	AppointmentEntity apEntity = session.find(AppointmentEntity.class, idSelected);
	            transaction = session.beginTransaction();
	            // save the student object
	            session.remove(apEntity);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
		
	}

	@Override
	public boolean isExits(String hoTen, int sdt, String ngayDat) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String sql = "FROM AppointmentEntity c  WHERE c.customer.tenKh = ?1 AND c.customer.sdt = ?2 AND c.ngayDat = ?3";
			Query query = session.createQuery(sql);
			query.setParameter(1, hoTen);
			query.setParameter(2, sdt);
			query.setParameter(3, ngayDat);
			AppointmentEntity result = (AppointmentEntity) query.uniqueResult();
			if(result != null) {
				return true;
			}

//			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Appointment> findByCustomerIdAndNgayDat(Long id, String ngayDat) {
		String hql = "FROM AppointmentEntity c WHERE c.customer.id = ?1 AND c.ngayDat = ? 2";
		rowMapper<AppointmentEntity, Appointment> rowmap = new AppointmentMapper();
		return query(hql, rowmap, id,ngayDat);
	}

	@Override
	public void updateDayAndTime(Long id , String ngayDat, String gioDat, String ngaySua, String gioSua) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String sql = "FROM AppointmentEntity c  WHERE c.customer.id = ?1 AND c.ngayDat= ?2 AND c.gioDat = ?3";
			Query query = session.createQuery(sql);
			query.setParameter(1, id);
			query.setParameter(2, ngayDat);
			query.setParameter(3, gioDat);
			
			AppointmentEntity result = (AppointmentEntity) query.uniqueResult();
			result.setNgayDat(ngaySua);
			result.setGioDat(gioSua);
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
	public long countByNgayDatAndGioDat(String ngayDat, String gioDat) {
		long result = 0;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			String sql = "Select count(*) FROM AppointmentEntity c  WHERE c.ngayDat = ?1 AND c.gioDat= ?2";
			Query query = session.createQuery(sql);
			
			query.setParameter(1, ngayDat);
			query.setParameter(2, gioDat);
			
			List<Long> results =  query.getResultList();
			result = results.get(0);
			session.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return result;
	}

	

}
