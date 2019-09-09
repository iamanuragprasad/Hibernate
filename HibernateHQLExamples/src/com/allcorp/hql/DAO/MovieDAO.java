package com.allcorp.hql.DAO;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.allcorp.hibernate.Util.HibernateUtil;
import com.allcorp.hql.DTO.MovieDTO;

public class MovieDAO {
	public int save(MovieDTO dto) {
		Session session=HibernateUtil.getFactory().openSession();
		Transaction tx=session.beginTransaction();
		Serializable pk=null;
		try {
			pk=session.save(dto);
			System.out.println("Pk generated \t "+pk);
			tx.commit();
		}catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
		}
		return (int) pk;

	}
	public MovieDTO getByName(String name) {
		Session session=HibernateUtil.getFactory().openSession();
		MovieDTO fromDb = null;
		try {
		String query="From MovieDTO where "+ "m_name='"+name+"'"; // Here m_name is column name within DB.
		Query hql=session.createQuery(query);
		fromDb=(MovieDTO) hql.uniqueResult();
		return fromDb;
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			session.close();
		}
		return fromDb;
	}
}
