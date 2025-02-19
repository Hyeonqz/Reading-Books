package org.hyeonqz.dddstart.event;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class EventsConfiguration {
	private final ApplicationContext applicationContext;

	@Bean
	public InitializingBean eventsInitializer() {
		return () -> Events.setPublisher(applicationContext);
	}

}
