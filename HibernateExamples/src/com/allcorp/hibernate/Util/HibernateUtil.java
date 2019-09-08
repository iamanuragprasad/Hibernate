/*This class is used to create Singleton SessionFactory.
Whenever we use this class then make sure to map annotated 
class to DB by using mapping tag in hibernate.cfg.xml file.
<mapping class="com.allcorp.hibernate.DTO.AddressDTO"></mapping>.
We can build jar of this class and add to lib to use it anywhere.*/
package com.allcorp.hibernate.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	public static SessionFactory getFactory() {
		return factory;
	}
	static {
		Configuration cfg=new Configuration();
		cfg.configure();
		factory=cfg.buildSessionFactory();
		System.out.println("Factory created....");
	}
}
