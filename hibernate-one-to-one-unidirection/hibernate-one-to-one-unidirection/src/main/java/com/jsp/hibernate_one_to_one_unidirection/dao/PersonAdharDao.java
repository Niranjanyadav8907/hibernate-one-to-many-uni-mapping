package com.jsp.hibernate_one_to_one_unidirection.dao;

import com.jsp.hibernate_one_to_one_unidirection.entity.Adhar;
import com.jsp.hibernate_one_to_one_unidirection.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PersonAdharDao {

	EntityManager em = 
			Persistence
			.createEntityManagerFactory("hibernate")
			.createEntityManager();

	EntityTransaction et = em.getTransaction();
	
	public Person savePersonAdharDao(Person person,Adhar adhar) {

		try {
			
			et.begin();
			//em.persist(adhar);
			em.persist(person);
			et.commit();
			return person;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Adhar saveAdharDao(Adhar adhar) {

		try {
			et.begin();
			em.persist(adhar);
			et.commit();
			return adhar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Person savePersonDao(Person person,long adharNumber) {

		Adhar adhar=em.find(Adhar.class, adharNumber);
		
		if(adhar!=null) {
			try {
				person.setAdhar(adhar);
				et.begin();
				em.persist(person);
				et.commit();
				return person;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}else {
			return null;
		}
	}
	
	public Person getPersonAdharByPersonIdDao(int personId) {

		Person person=em.find(Person.class, personId);
		
		if(person!=null) {
			return person;
		}else {
			return null;
		}
	}
	
	public boolean deletePersonByPersonIdDao(int personId) {

		Person person=em.find(Person.class, personId);
		
		if(person!=null) {
			et.begin();
			em.remove(person);
			et.commit();
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteAdharByAdharNumberDao(long adharNumber) {

		Adhar adhar=em.find(Adhar.class, adharNumber);
		
		Query query=em.createNativeQuery("select * from person where adhar_adharno=?",Person.class);
		query.setParameter(1, adharNumber);
		
		Person person = (Person) query.getSingleResult();
		
		System.out.println(person);
		
		if(adhar!=null) {
			et.begin();
			person.setAdhar(null);
			em.merge(person);
			em.remove(adhar);
			et.commit();
			return true;
		}else {
			return false;
		}
	}
}
