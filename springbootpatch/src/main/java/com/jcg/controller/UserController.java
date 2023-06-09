package com.jcg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcg.dto.PatchDto;
import com.jcg.exception.NotFoundEx;
import com.jcg.exception.NotYetImplementedEx;
import com.jcg.model.User;
import com.jcg.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/all")
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable(name = "id") int id) throws NotFoundEx {
		return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Boolean> updatePartially(@PathVariable(name = "id") int id, @RequestBody PatchDto dto)
			throws NotYetImplementedEx, NotFoundEx {
		// skipping validations for brevity
		if (dto.op().equalsIgnoreCase("update")) {
			boolean result = service.partialUpdate(id, dto.key(), dto.value());
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		} else {
			throw new NotYetImplementedEx("NOT_YET_IMPLEMENTED");
		}
	}
}
