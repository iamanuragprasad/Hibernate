package com.training.orm.Util;

import com.training.orm.DAO.CountryDAO;
import com.training.orm.DTO.CapitalDTO;
import com.training.orm.DTO.CountryDTO;

public class Tester {
	public static void main(String[] args) {
		CountryDTO india=new CountryDTO();
		india.setCode(91);
		india.setFlower("Lotus");
		india.setName("INDIA");
		india.setPopInMillions(25);
		CapitalDTO newDelhi=new CapitalDTO();
		newDelhi.setMetro(true);
		newDelhi.setName("NEW Delhi");
		newDelhi.setPopInMillions(7);
		india.setCapitaldto(newDelhi);
		newDelhi.setCountryDTO(india);
		CountryDAO dao=new CountryDAO();
		dao.save(india);
		System.out.println("Details Saved");
	}

}
