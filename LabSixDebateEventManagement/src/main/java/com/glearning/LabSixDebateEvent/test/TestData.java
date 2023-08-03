package com.glearning.LabSixDebateEvent.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.glearning.LabSixDebateEvent.dao.DebateEventRepository;
import com.glearning.LabSixDebateEvent.dao.UserRepository;
import com.glearning.LabSixDebateEvent.model.Role;
import com.glearning.LabSixDebateEvent.model.Student;
import com.glearning.LabSixDebateEvent.model.Users;

/*I have included this class to avoid the extra work needed in entering new data into the Users tables, Roles Table and
users_roles JOIN table. Also, so that I can insert some dummy Student data. Please note. you can use the normal 
way of adding data into the tables through mysql queries in mysql workbench*/

@Configuration
public class TestData {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DebateEventRepository debateEventRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PersistenceContext
	private EntityManager entityManager;

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void loadUsers(ApplicationReadyEvent event) {

		// addding users and roles

		Users kiran = new Users("kiran", this.passwordEncoder.encode("admin123"));
		Users vinay = new Users("vinay", this.passwordEncoder.encode("user456"));

		Role userRole = new Role("USER");
		Role adminRole = new Role("ADMIN");

		List<Role> kiranRoles = new ArrayList<>();
		kiranRoles.add(userRole);
		kiranRoles.add(adminRole);
		kiran.setRoles(kiranRoles);

		List<Role> vinayRoles = new ArrayList<>();
		vinayRoles.add(userRole);
		vinay.setRoles(vinayRoles);

		this.userRepository.save(kiran);
		this.userRepository.save(vinay);
		
		 // Associate roles with users using EntityManager
        kiran.getRoles().forEach(role -> entityManager.persist(role));
        vinay.getRoles().forEach(role -> entityManager.persist(role));

       //commits these changes immediately into the database
        entityManager.flush();

		// adding some student data

		Student student1 = new Student();
		student1.setFirstName("Suresh ");
		student1.setLastName("Reddy");
		student1.setCourse("B. TECH");
		student1.setCountry("India");

		Student student2 = new Student();
		student2.setFirstName("Murali");
		student2.setLastName("Mohan");
		student2.setCourse("B.Arch");
		student2.setCountry("Canada");

		Student student3 = new Student();
		student3.setFirstName("Daniel");
		student3.setLastName("Denson");
		student3.setCourse("MS");
		student3.setCountry("New Zealand");

		Student student4 = new Student();
		student4.setFirstName("Tanya Gupta");
		student4.setLastName("Mohan");
		student4.setCourse("B.Com");
		student4.setCountry("USA");

		this.debateEventRepository.save(student1);
		this.debateEventRepository.save(student2);
		this.debateEventRepository.save(student3);
		this.debateEventRepository.save(student4);

	}

}
