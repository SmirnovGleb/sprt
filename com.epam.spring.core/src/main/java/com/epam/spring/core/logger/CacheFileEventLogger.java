package com.epam.spring.core.logger;

import java.util.ArrayList;
import java.util.List;

import com.epam.spring.core.entity.Event;

public class CacheFileEventLogger extends FileEventLogger {
	private int cacheSize;
	private ArrayList<Event> cache = new ArrayList<Event>();

	public void logEvent(Event event) {
		cache.add(event);
		if (cache.size() == cacheSize) {
			writeEventsFromCache();
			cache.clear();
		}
	}

	private void writeEventsFromCache() {
		
	}

	public void destroy() {
		System.out.println("destroy");
	}

}
