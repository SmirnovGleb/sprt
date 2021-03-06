package com.epam.spring.core.logger;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.epam.spring.core.entity.Event;
import com.epam.spring.core.entity.EventLogger;
import com.epam.spring.core.entity.EventType;
import javax.annotation.PostConstruct;

@Component("FileEventLogger")
public class FileEventLogger implements EventLogger{
	@Value("hello")
	private String fileName;
	private File file;

	public void logEvent(Event event, EventType type) {
		try {
			FileUtils.writeStringToFile(file, event.toString(), true);
		} catch (IOException e) {
			System.out.println("error");
		}
	}
	@PostConstruct
	public void init() {
		System.out.println("init"+ this.getClass());
		this.file = new File(fileName); 
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
