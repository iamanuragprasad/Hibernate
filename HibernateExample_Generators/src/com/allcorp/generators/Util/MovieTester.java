package com.allcorp.generators.Util;

import com.allcorp.generators.DAO.MovieDAO;
import com.allcorp.generators.DTO.MovieDTO;

public class MovieTester {
	public static void main(String[] args) {
		MovieDTO conjuring2=new MovieDTO();
		conjuring2.setCertificate("U/A");
		conjuring2.setDuration(126);
		conjuring2.setName("CONJURING 2");
		MovieDAO dao=new MovieDAO();
		Integer pk=dao.save(conjuring2);
	}

}
