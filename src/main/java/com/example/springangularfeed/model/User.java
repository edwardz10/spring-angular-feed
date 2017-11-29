package com.example.springangularfeed.model;

import java.util.Date;

public class User {

	private Long id;
	private Date timestamp;
	private Role role;

	public User() {}

	public User(Long id, Date timestamp, Role role) {
		this.id = id;
		this.timestamp = timestamp;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
