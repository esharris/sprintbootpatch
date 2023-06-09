package com.jcg.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcg.dao.UserDao;
import com.jcg.exception.NotFoundEx;
import com.jcg.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserDao dao;

	public long getCount() {
		return dao.count();
	}

	public void saveAll(List<User> users) {
		dao.saveAll(users);
	}

	public List<User> getAll() {
		return dao.findAll();
	}

	public User getById(int id) throws NotFoundEx {
		log.info("Search id={}", id);
		return dao.findById(id).orElseThrow(() -> new NotFoundEx("RESOURCE_NOT_FOUND"));
	}

	public boolean partialUpdate(int id, String key, String value) throws NotFoundEx {
		log.info("Search id={}", id);
		Optional<User> optional = dao.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();

			if (key.equalsIgnoreCase("fullName")) {
				log.info("Updating full name");
				user.setFullName(value);
			}
			if (key.equalsIgnoreCase("age")) {
				log.info("Updating age");
				user.setAge(Integer.parseInt(value));
			}

			dao.save(user);
			return true;
		} else {
			throw new NotFoundEx("RESOURCE_NOT_FOUND");
		}
	}
}
