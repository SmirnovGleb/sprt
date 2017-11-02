package com.epam.spring.core.entity;

public interface EventLogger {
	void logEvent(Event event, EventType type);
}
