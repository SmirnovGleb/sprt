package com.epam.spring.core.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.core.entity.Client;
import com.epam.spring.core.entity.Event;
import com.epam.spring.core.entity.EventLogger;
import com.epam.spring.core.entity.EventType;

@Configuration
public class App {
	@Autowired
	private Client client;
	@Autowired
	@Qualifier("cacheFileEventLogger")
	private EventLogger logger;
	private Map<EventType, EventLogger> loggers;
	private EventType type;

	@Autowired

	public App(Map<EventType, EventLogger> loggers) {
		this.loggers = loggers;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public EventLogger getLogger() {
		return logger;
	}

	public void setLogger(EventLogger logger) {
		this.logger = logger;
	}

	public Map<EventType, EventLogger> getLoggers() {
		return loggers;
	}

	public void setLoggers(Map<EventType, EventLogger> loggers) {
		this.loggers = loggers;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		App app = (App) ctx.getBean("app");
		app.logEvent((Event) ctx.getBean("event"), app.type);

		ctx.close();

	}

	private void logEvent(Event event, EventType type) {
		EventLogger currentLogger = loggers.get(type);
		System.out.println(currentLogger);
		if (currentLogger == null) {
			currentLogger = logger;
		}
		currentLogger.logEvent(event, type);
	}
}
