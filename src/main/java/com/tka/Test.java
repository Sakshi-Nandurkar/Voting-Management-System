package com.tka;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Address.class);
		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(VotingCard.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Person p1 = new Person(6242, "Suzy Joel");
		VotingCard v1 = new VotingCard("TMS1234", "Mumbai");
		p1.setVotingcard(v1);
		
		
		Address addr1 = new Address(400001, "Mumbai");
		Address addr2 = new Address(400002, "Pune");

		addr1.setPerson(p1);
		addr2.setPerson(p1);

		p1.setAddress(new ArrayList<Address>());
		p1.getAddress().add(addr1);
		p1.getAddress().add(addr2);

		session.save(p1);
		
		tx.commit();
		session.close();
		
		
	}

}
