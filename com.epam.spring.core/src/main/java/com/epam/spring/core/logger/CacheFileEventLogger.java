package com.epam.spring.core.logger;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.epam.spring.core.entity.Event;

@Component("cacheFileEventLogger")
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

	@PreDestroy
	public void destroy() {
		System.out.println("destroy");
	}

}
