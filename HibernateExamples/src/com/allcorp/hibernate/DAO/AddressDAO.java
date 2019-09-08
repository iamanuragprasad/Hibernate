package com.allcorp.hibernate.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.allcorp.hibernate.DTO.AddressDTO;
import com.allcorp.hibernate.Util.HibernateUtil;

public class AddressDAO {
	
	  public void save(AddressDTO dto) {
	  System.out.println("Address details start to save");
	  Configuration cfg=new Configuration(); 
	  cfg.configure(); 
	  cfg.addAnnotatedClass(AddressDTO.class);
	  SessionFactory factory=cfg.buildSessionFactory(); 
	  Session session=factory.openSession();
	  Transaction tx=session.beginTransaction();
	  session.save(dto); 
	  tx.commit(); 
	  session.close(); 
	  factory.close();
	  
	  }
	 
	public void fetch() {
		System.out.println("Address detail start to fetch....");
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(AddressDTO.class);
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		AddressDTO fromDB=session.get(AddressDTO.class, 1);
		System.out.println(fromDB.getCity());
	}
	public void update() {
		System.out.println("Address detail start to update....");
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(AddressDTO.class);
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		AddressDTO dto=session.get(AddressDTO.class, 1);
		dto.setCity("Bangalore");
		session.update(dto);
		tx.commit();
		session.close();
		factory.close();
	}

	/*
	 * Added Singleton SessionFactory logic here. 
	 * Logic for Singleton SessionFactory
	 * is there in Util folder in HibernateUtil.java.
	 * Mapping Entity class should be done in XML file here always
	 */
	public void delete() {
		System.out.println("Delete operation started....");
		Session session=HibernateUtil.getFactory().openSession();
		Transaction tx=session.beginTransaction();
		AddressDTO address=session.get(AddressDTO.class, 1);
		session.delete(address);
		tx.commit();
		session.close();
	}

}
