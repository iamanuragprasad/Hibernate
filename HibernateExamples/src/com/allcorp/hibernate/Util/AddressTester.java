package com.allcorp.hibernate.Util;

import com.allcorp.hibernate.DAO.AddressDAO;
import com.allcorp.hibernate.DTO.AddressDTO;

public class AddressTester {
	public static void main(String[] args) {
		AddressDTO address=new AddressDTO();
		address.setAid(1);
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setStreet("5 cross");
		AddressDAO dao=new AddressDAO();
		dao.save(address);
		dao.fetch();
		dao.update();
		System.out.println("Data Udated");
	}

}
