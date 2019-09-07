package com.allcorp.hibernate.Util;

import com.allcorp.hibernate.DAO.CarDAO;
import com.allcorp.hibernate.DTO.CarDTO;

public class Tester {
	public static void main(String[] args) {
		CarDTO audi=new CarDTO();
		audi.setBrand("Audi123");
		audi.setMaxSpeed(280);
		audi.setPrimary(50);
		audi.setPrimary(2);
		CarDAO dao=new CarDAO();
		dao.save(audi);
		System.out.println("Anurag");
	}

}
