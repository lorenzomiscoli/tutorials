package com.lorenzomiscoli.jpa_attribute_converter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.lorenzomiscoli.jpa_attribute_converter.model.Country;
import com.lorenzomiscoli.jpa_attribute_converter.model.enums.CountryCode;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("default");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		Country country = new Country();
		country.setName("Italy");
		country.setCode(CountryCode.ITALY);
		em.persist(country);
		em.getTransaction().commit();
		em.close();
		emFactory.close();
	}

}
