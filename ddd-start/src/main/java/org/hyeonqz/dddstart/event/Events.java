package org.hyeonqz.dddstart.event;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEventPublisher;

public class Events {
	private static ApplicationEventPublisher eventPublisher;

	static void setPublisher(ApplicationEventPublisher publisher) {
		Events.eventPublisher = publisher;
	}

	public static void raise(Object event) {
		if(eventPublisher != null) {
			eventPublisher.publishEvent(event);
		}
	}
}
