package org.hyeonqz.dddstart.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderCanceledEventHandler {
	private final RefundService refundService;

	@EventListener(OrderCanceledEvent.class)
	public void handle(OrderCanceledEvent event) {
		refundService.refund(event.getOrderNumber());
	}
}
