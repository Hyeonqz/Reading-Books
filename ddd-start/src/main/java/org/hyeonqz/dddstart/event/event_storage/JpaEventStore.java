package org.hyeonqz.dddstart.event.event_storage;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JpaEventStore implements EventStore {
	private final ObjectMapper objectMapper;
	private final JdbcTemplate jdbcTemplate;

	@Override
	public void save (Object event) {
		EventEntry entry = new EventEntry(event.getClass().getName(),
			"application/json", toJson(event));

		jdbcTemplate.update(
			"insert into evententry" +
				"(type, content_type, payload, timestamp)" +
				"values(?,?,?,?)",
			ps -> {
				ps.setString(1, entry.getType());
				ps.setString(2, entry.getContentType());
				ps.setString(3, entry.getPayload());
				ps.setTimestamp(4, new Timestamp(entry.getTimestamp()));
			}
		);
	}


	@Override
	public List<EventEntry> get (long offset, long limit) {
		// 조회 쿼
		return List.of();
	}

	private String toJson (Object event) {
		try {
			return objectMapper.writeValueAsString(event);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}