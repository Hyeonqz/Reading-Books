package org.hyeonqz.dddstart.event;

import org.springframework.stereotype.Service;

@Service
public class RefundService {

	public void refund (String orderNumber) {
		System.out.println("환불 진행 중");
	}

}
