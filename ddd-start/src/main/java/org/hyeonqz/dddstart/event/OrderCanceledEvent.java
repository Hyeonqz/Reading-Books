package org.hyeonqz.dddstart.event;

import lombok.Getter;

@Getter
public class OrderCanceledEvent extends Event{

	public OrderCanceledEvent (String orderNumber) {
		super();
		this.orderNumber = orderNumber;
	}

	private String orderNumber;

}
