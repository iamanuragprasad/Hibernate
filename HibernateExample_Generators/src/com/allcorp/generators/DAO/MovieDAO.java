package com.allcorp.generators.DAO;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.allcorp.generators.DTO.MovieDTO;
import com.allcorp.hibernate.Util.HibernateUtil;

public class MovieDAO {
public int save(MovieDTO dto) {
	System.out.println("Movie details starts saving");
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
	}
	finally {
	session.close();
	}
	return (int) pk;
}
}
