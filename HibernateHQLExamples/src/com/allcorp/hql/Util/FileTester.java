package com.allcorp.hql.Util;

import com.allcorp.hql.DAO.FileDAO;

public class FileTester {
public static void main(String[] args) {
	FileDAO dao=new FileDAO();
	dao.getByName("Welcome");
}
}
