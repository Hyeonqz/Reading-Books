package org.hyeonqz.dddstart.application;

import org.hyeonqz.dddstart.infrastructure.ProductRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {
	private final ProductRepository productRepository;


}
