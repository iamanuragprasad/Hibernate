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
			/*
			 * Below m_name is column name within DB. Don't use column name in HQL as HQL
			 * uses class property. Use the one below.
			 */		
		//String query="From MovieDTO where "+ "m_name='"+name+"'"; 
		String query="From MovieDTO where "+"name='"+name+"'"; //Here name is a property in  MovieDTO
		// Notice here below we are using certificate and name( class properties) instead of column name as HQL uses class properties.
		String query1="select certificate from MovieDTO where name='Singham 2'"; // Notice here we are using certificate and name( class properties)
		String query2="Select certificate, duration from MovieDTO where name='Singham 2'";
		Query hql=session.createQuery(query);
		Query hql1=session.createQuery(query1);
		Query hql2=session.createQuery(query2);
		fromDb=(MovieDTO) hql.uniqueResult();
		String cert= (String) hql1.uniqueResult();// Based on Projection type only uniqueResult() return type is based.
		System.out.println(cert);
		Object[] values=(Object[]) hql2.uniqueResult();
		System.out.println(values.length);
		System.out.println(values[0]);
		System.out.println(values[1]);
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
