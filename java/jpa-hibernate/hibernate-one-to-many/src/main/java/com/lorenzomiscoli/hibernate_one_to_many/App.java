package com.lorenzomiscoli.hibernate_one_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.lorenzomiscoli.hibernate_one_to_many.model.Customer;
import com.lorenzomiscoli.hibernate_one_to_many.model.Order;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("default");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		Customer customer = new Customer();
		customer.addOrder(new Order());
		em.persist(customer);
		em.getTransaction().commit();
		em.close();
		emFactory.close();
	}
	
}
