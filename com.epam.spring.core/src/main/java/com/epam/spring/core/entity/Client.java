package com.epam.spring.core.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("client")
public class Client {
	private String id;
	private String fullName;
	private String greeting;

	public String getId() {
		return id;
	}

	@Value("${id}")
	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	@Value("${fullname}")
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGreeting() {
		return greeting;
	}

	@Value("${greeting}")
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", fullName=" + fullName + ", greeting=" + greeting + "]";
	}

}
