package com.jcg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "my_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class User {

	public static UserBuilder builder() {
		return new UserBuilder();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column(name = "full_name", nullable = false)
	String fullName;

	@Column(name = "age")
	int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
