package org.hyeonqz.dddstart.event;

import lombok.Getter;

@Getter
public class Order {
	private String number;
	private String state;


	public void cancel() {
		this.verityShipped();
		this.state = "CANCELED";
		Events.raise(new OrderCanceledEvent(number));
	}

	private void verityShipped () {
	}

}
