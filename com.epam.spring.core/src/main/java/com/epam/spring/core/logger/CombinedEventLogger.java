package com.epam.spring.core.logger;

import java.util.List;

import com.epam.spring.core.entity.Event;
import com.epam.spring.core.entity.EventLogger;
import com.epam.spring.core.entity.EventType;

public class CombinedEventLogger implements EventLogger{
	List<EventLogger> loggers;
	
	public List<EventLogger> getLoggers() {
		return loggers;
	}
	public void setLoggers(List<EventLogger> loggers) {
		this.loggers = loggers;
	}
	
	public void logEvent(Event event, EventType type) {
		for(EventLogger logger:loggers){
			logger.logEvent(event, type);
		}
		
	}

}
