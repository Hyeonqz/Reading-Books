package org.hyeonqz.dddstart.event.event_storage;

import java.util.List;

public interface EventStore {
	void save(Object event);
	List<EventEntry> get(long offset, long limit);
}
