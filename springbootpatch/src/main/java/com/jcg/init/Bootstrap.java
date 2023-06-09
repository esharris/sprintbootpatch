package com.jcg.init;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jcg.model.User;
import com.jcg.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserService service;

	@Override
	public void run(String... args) throws Exception {
		loadUsers();
	}

	private void loadUsers() {
		long total = service.getCount();
		if (total == 0) {
			List<User> users = createUsers();
			service.saveAll(users);
			log.info("Data inserted");
		} else {
			log.info("Data already present");
		}
	}

	private List<User> createUsers() {
		List<User> users = new ArrayList<>();
		users.add(User.builder().fullName("John").age(25).build());
		users.add(User.builder().fullName("Jane").age(30).build());
		users.add(User.builder().fullName("Adam").age(32).build());
		return users;
	}
}
