package com.allcorp.hql.Util;

import com.allcorp.hql.DAO.MovieDAO;
import com.allcorp.hql.DTO.MovieDTO;

public class MovieTester {
	public static void main(String[] args) {
		MovieDAO dao=new MovieDAO();
		dao.getMultipleObjects();
		dao.update();
		dao.updateUsingPlaceholders();
	}
}
