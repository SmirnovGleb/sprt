package com.epam.spring.core.app;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.core.entity.Client;
import com.epam.spring.core.entity.Event;
import com.epam.spring.core.entity.EventLogger;
import com.epam.spring.core.entity.EventType;

/**
 * Hello world!
 *
 */
public class App 
{
	private Client client;
	private EventLogger logger;
	private Map<EventType, EventLogger> loggers;
	private EventType type;
	
    public App(Client client, EventLogger logger, Map<EventType, EventLogger> loggers) {
		super();
		this.client = client;
		this.logger = logger;
		this.loggers = loggers;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public static void main( String[] args )
    {
		
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		App app = (App)ctx.getBean("app");
		app.logEvent((Event) ctx.getBean("event"), app.type);
		
		ctx.close();

       
    }
    
    private void logEvent(Event event, EventType type) {
    	EventLogger currentLogger = loggers.get(type); 
    	System.out.println(currentLogger);
    	if(currentLogger == null) {
    		currentLogger = logger;
    	}
    	currentLogger.logEvent(event, type);    	
    }
}
