package org.hyeonqz.dddstart.event;

import lombok.Getter;

@Getter
public abstract class Event {
	private long timestamp;

	public Event () {
		this.timestamp = System.currentTimeMillis();
	}

}
