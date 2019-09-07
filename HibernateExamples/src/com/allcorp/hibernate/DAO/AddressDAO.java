package com.allcorp.hibernate.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.allcorp.hibernate.DTO.AddressDTO;

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
		dto.setCity("Mangalore");
		session.update(dto);
		tx.commit();
		session.close();
		factory.close();
	}

}
