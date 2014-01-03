package com.yodes.excel.web.security;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:test-dao-context.xml", "classpath:security-context.xml"
})
public class MongoUserRepositoryTest {

	@Autowired
	private MongoUserRepository userRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Before
	public void setup() {
		mongoTemplate.dropCollection(MongoUser.class);
	}

	@Test
	public void testResultsDaoConstruction() {
		TestCase.assertNotNull(userRepository);
	}

	@Test
	public void testAdd() {
		MongoUser adminUser = newUser();
		userRepository.save(adminUser);
		List<MongoUser> users = userRepository.findAll();
		TestCase.assertEquals(1, users.size());
		MongoUser dbUser = users.get(0);
		TestCase.assertEquals(dbUser.getUsername(), adminUser.getUsername());
	}

	public MongoUser newUser() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority authoritie = new SimpleGrantedAuthority("ROLE_ADMIN");
		authorities.add(authoritie);
		MongoUser adminUser = new MongoUser("yoda", "reloaded", authorities);
		return adminUser;
	}

	@Test
	public void testDelete() {
		MongoUser adminUser = newUser();
		userRepository.save(adminUser);
		List<MongoUser> users = userRepository.findAll();
		TestCase.assertEquals(1, users.size());
		userRepository.delete(users.get(0));
		users = userRepository.findAll();
		TestCase.assertEquals(0, users.size());
	}
}
