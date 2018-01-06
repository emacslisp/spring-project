package com.lab.springscratch;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");
		try {
			
			/*Offer offer1 = new Offer("wudi","test@test.com","coding java");
			Offer offer2 = new Offer("eddywu","test@test.com","coding java");
			
			if(offersDao.create(offer1)) {
				System.out.println("Create offer1: " + offer1);
			}
			
			if(offersDao.create(offer2)) {
				System.out.println("Create offer2: " + offer2);
			}*/
			
			//offersDao.delete(80);
			
			Offer offer2 = new Offer(82, "eddywu","eddywu@test.com","coding in spring");
			offersDao.update(offer2);
			
			List<Offer> offers = offersDao.getOffers();

			for (Offer offer : offers) {
				System.out.println(offer);
			}
			
			Offer offer = offersDao.getOffer(2);
			System.out.println(offer);
		} 
		catch(CannotGetJdbcConnectionException e) {
			System.out.println("Can not establish jdbc connection");
		}
		catch (DataAccessException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		}
		catch(Exception e) {
			System.out.println(e.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();
	}
}
