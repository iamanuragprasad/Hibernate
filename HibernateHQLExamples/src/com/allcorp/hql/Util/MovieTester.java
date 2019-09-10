package com.allcorp.hql.Util;

import com.allcorp.hql.DAO.MovieDAO;
import com.allcorp.hql.DTO.MovieDTO;

public class MovieTester {
	public static void main(String[] args) {
		MovieDAO dao=new MovieDAO();
		MovieDTO singham2=new MovieDTO();
		  singham2.setCertificate("U/A"); 
		  singham2.setDuration(126);
		  singham2.setName("Singham 2");
		//dao.save(singham2);
		MovieDTO movie=dao.getByName("Singham 2");
		System.out.println(movie);// override toString method in MovieDTO.
	}
}
