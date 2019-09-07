package com.allcorp.hibernate.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.allcorp.hibernate.DTO.CarDTO;

public class CarDAO {
	public void save(CarDTO dto) {
		System.out.println("Car info start to save");
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(CarDTO.class);
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();
		factory.close();
	}
	
	

}
