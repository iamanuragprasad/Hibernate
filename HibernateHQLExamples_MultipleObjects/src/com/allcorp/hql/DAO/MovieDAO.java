package com.allcorp.hql.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.allcorp.hibernate.Util.HibernateUtil;
import com.allcorp.hql.DTO.MovieDTO;

public class MovieDAO {
	
	public void getMultipleObjects(){
		Session session=HibernateUtil.getFactory().openSession();
		try {
		String hql="select movie from MovieDTO as movie";
		String hql1="select movie.name,movie.id from MovieDTO as movie";
		Query query=session.createQuery(hql); // When ever we select all entities or select all entities with property name then list() returns DTO type.
		Query query1=session.createQuery(hql1);// When ever we use class property type then list() returns generic Object type.
			  List<MovieDTO> list=query.list();
			  System.out.println("No of entities \t" +list.size()); 
			  for(MovieDTO movieDTO:list) {
				  System.out.println(movieDTO); // It will print over-ridden toString() implementation in MovieDTO }
			  }
			 
		List<Object[]> list1=query1.list();
		System.out.println("No of entities \t" + list1.size());
		for(Object[] objects:list1) {
			System.out.println(objects.length); 
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
		}catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			session.close();
		}
		}
	
	/* Method to update datain DB using HQl
	 * 
	 * */
	public void update() {
		Session session=HibernateUtil.getFactory().openSession();
		Transaction tx=session.beginTransaction();
		String hql="update MovieDTO set name='X-Men'" +" where id=2";
		Query query=session.createQuery(hql);
		query.executeUpdate();
		tx.commit();
		session.close();
	}
	public void updateUsingPlaceholders() {
		Session session=HibernateUtil.getFactory().openSession();
		Transaction tx=session.beginTransaction();
		String hql="update MovieDTO set name=?" +" where id=?";
		Query query=session.createQuery(hql);
		query.setString(0, "Jungle Book");
		query.setInteger(1, 4);
		query.executeUpdate();
		tx.commit();
		session.close();
	}
	
}
