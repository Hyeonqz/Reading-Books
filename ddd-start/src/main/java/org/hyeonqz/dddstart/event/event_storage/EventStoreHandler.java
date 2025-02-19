package org.hyeonqz.dddstart.event.event_storage;

import org.hyeonqz.dddstart.event.Event;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class EventStoreHandler {
	private final EventStore eventStore;

	@EventListener(Event.class)
	public void handle(Event event) {
		eventStore.save(event);
	}
}
