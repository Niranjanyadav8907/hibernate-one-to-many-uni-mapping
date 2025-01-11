package com.jsp.hibernate_one_to_one_unidirection.controller;

import java.time.LocalDate;

import com.jsp.hibernate_one_to_one_unidirection.dao.PersonAdharDao;
import com.jsp.hibernate_one_to_one_unidirection.entity.Adhar;
import com.jsp.hibernate_one_to_one_unidirection.entity.Person;

public class InsertAdharController {

	public static void main(String[] args) {
		
		PersonAdharDao adharDao = new PersonAdharDao();
//		
		Adhar adhar = new Adhar(7865431234l, "jitesh-sharma", "noida-sector-3", LocalDate.parse("1999-10-10"));
//		
		adharDao.saveAdharDao(adhar);
		
//	Person person = new Person(8787872, "Vandya", "vandya@hotmail.com", 4567890);
//	adharDao.savePersonDao(person,7865431234l);
		
//		Person person=adharDao.getPersonAdharByPersonIdDao(5555);
		
//		System.out.println(person);
		
//		Adhar adhar=person.getAdhar();
//		
//		System.out.println(adhar);
		
		boolean b=adharDao.deletePersonByPersonIdDao(432167);
	}
}
