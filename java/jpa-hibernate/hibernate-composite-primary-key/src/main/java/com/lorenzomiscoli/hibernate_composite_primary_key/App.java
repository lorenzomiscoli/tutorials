package com.lorenzomiscoli.hibernate_composite_primary_key;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.lorenzomiscoli.hibernate_composite_primary_key.model.Employee;
import com.lorenzomiscoli.hibernate_composite_primary_key.model.EmployeeId;
import com.lorenzomiscoli.hibernate_composite_primary_key.model.Language;
import com.lorenzomiscoli.hibernate_composite_primary_key.model.Task;
import com.lorenzomiscoli.hibernate_composite_primary_key.model.TaskId;
import com.lorenzomiscoli.hibernate_composite_primary_key.model.Translation;
import com.lorenzomiscoli.hibernate_composite_primary_key.model.TranslationId;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("default");
		EntityManager em = emFactory.createEntityManager();
		em.find(Task.class, new TaskId("22VD14J", "test"));
		em.find(Employee.class, new EmployeeId(1L, 1L));
		Language language = new Language();
		language.setCode("ita");
		em.find(Translation.class, new TranslationId(1L, language));
		em.close();
		emFactory.close();
	}

}
