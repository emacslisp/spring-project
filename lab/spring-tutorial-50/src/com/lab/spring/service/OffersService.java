package com.lab.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.spring.dao.*;
import java.util.*;

@Service("offersService")
public class OffersService {
	
	private OffersDAO offersDao;

	@Autowired
	public void setOffersDao(OffersDAO offersDao) {
		this.offersDao = offersDao;
	}



	public List<Offer> getCurrent() {
		
		return offersDao.getOffers();
		
	}



	public void createOffer(Offer offer) {
		
		offersDao.create(offer);
	}



	public void throwTestException() {
		// TODO Auto-generated method stub
		offersDao.getOffer(9999);
	}

}
