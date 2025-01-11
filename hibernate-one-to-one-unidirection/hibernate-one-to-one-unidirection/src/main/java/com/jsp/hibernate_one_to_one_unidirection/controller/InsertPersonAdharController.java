package com.jsp.hibernate_one_to_one_unidirection.controller;

import java.time.LocalDate;

import com.jsp.hibernate_one_to_one_unidirection.dao.PersonAdharDao;
import com.jsp.hibernate_one_to_one_unidirection.entity.Adhar;
import com.jsp.hibernate_one_to_one_unidirection.entity.Person;

public class InsertPersonAdharController {

	public static void main(String[] args) {
		
		PersonAdharDao adharDao = new PersonAdharDao();
		
//		Adhar adhar = new Adhar(76543, "mukesh-sharma", "noida-sector-3", LocalDate.parse("1999-10-10"));
//		
//		Person person = new Person(5432, "nilesh-sharma", "n234@gmail.com", 999, adhar);
		
		//person.setAdhar(adhar);
		
//		adharDao.savePersonAdharDao(person, null);
		
		adharDao.deleteAdharByAdharNumberDao(686868);
	}
}
