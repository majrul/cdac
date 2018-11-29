package com.cdac.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.cdac.dao.GenericDao;
import com.cdac.entity.custsub.Subscription;
import com.cdac.entity.custsub.User;
import com.cdac.entity.custsub.UserSubscriptionLink;

public class UserSubscriptionTest2 {

	@Test
	public void addUsers() {
		User u1 = new User();
		u1.setUsername("majrul");
		u1.setEmail("majrul@gmail.com");

		User u2 = new User();
		u2.setUsername("john");
		u2.setEmail("john@gmail.com");

		GenericDao dao = new GenericDao();
		dao.save(u1);
		dao.save(u2);
	}
	
	@Test
	public void addSubscriptions() {
		Subscription s1 = new  Subscription();
		s1.setType("AMAZON PRIME");
		s1.setCost(999);
		s1.setDuration(365);

		Subscription s2 = new  Subscription();
		s2.setType("HOTSTAR");
		s2.setCost(799);
		s2.setDuration(365);

		GenericDao dao = new GenericDao();
		dao.save(s1);
		dao.save(s2);
	}
	
	@Test
	public void subscribe() {
		GenericDao dao = new GenericDao();
		User u1 = dao.fetch(User.class, 1); //majrul
		Subscription s1 = dao.fetch(Subscription.class, 1); //amazon prime
		Subscription s2 = dao.fetch(Subscription.class, 2); //hotstar
		
		UserSubscriptionLink l = new UserSubscriptionLink();
		l.setUser(u1);
		l.setSubscription(s1);
		l.setSubscriptionDate(new Date());
		dao.save(l);
		
		l = new UserSubscriptionLink();
		l.setUser(u1);
		l.setSubscription(s2);
		l.setSubscriptionDate(new Date());
		dao.save(l);
		
	}

}
