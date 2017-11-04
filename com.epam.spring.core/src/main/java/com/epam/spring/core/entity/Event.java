package com.epam.spring.core.entity;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Event {
	private int id;
	@Value("Hello")
	private String msg;
	private Date date;
	private Client client;
	@Autowired
	public Event(Date date, Client client) {
		super();
		this.date = date;
		this.client = client;
		this.id = new Random().nextInt();
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", msg=" + msg + ", date=" + date + ", client=" + client + "]";
	}
	
	
}
