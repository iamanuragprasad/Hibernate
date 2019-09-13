package com.allcorp.hql.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.allcorp.hibernate.Util.HibernateUtil;
import com.allcorp.hql.DTO.FileDTO;

public class FileDAO {
	public FileDTO getByName(String name) {
		Session session=HibernateUtil.getFactory().openSession();
		FileDTO fileDto=null;
		try {
		//String qry="From FileDTO where "+ "f_name='"+name+"'"; // Use below one.
		String qry="From FileDTO where "+" name='"+name+"'";
		Query hql=session.createQuery(qry);
		fileDto=(FileDTO) hql.uniqueResult();
		System.out.println(fileDto.getLocation());
		return fileDto;
		}catch(HibernateException he) {
			he.printStackTrace();
			
		}
		finally {
			session.close();
		}
		return fileDto;
		
	}

}
