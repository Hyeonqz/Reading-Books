package org.hyeonqz.dddstart.event.event_storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventEntry {
	private Long id;
	private String type;
	private String contentType;
	private String payload;
	private long timestamp;

	public EventEntry (String type, String contentType, String payload) {
		this.type = type;
		this.contentType = contentType;
		this.payload = payload;
		this.timestamp = System.currentTimeMillis();
	}

}
