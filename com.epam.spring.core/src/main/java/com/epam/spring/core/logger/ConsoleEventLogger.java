package com.epam.spring.core.logger;

import com.epam.spring.core.entity.Event;
import com.epam.spring.core.entity.EventLogger;
import com.epam.spring.core.entity.EventType;

public class ConsoleEventLogger implements EventLogger{
	public void logEvent(Event event, EventType type) {
		System.out.println(event);
	}
}
