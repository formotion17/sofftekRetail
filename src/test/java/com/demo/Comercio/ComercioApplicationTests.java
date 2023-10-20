package com.demo.Comercio;


import com.demo.Comercio.model.dto.product.ProductFindRequest;
import com.demo.Comercio.model.dto.product.ProductFindResponse;
import org.springframework.http.HttpHeaders;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ComercioApplicationTests {


	private TestRestTemplate restTemplate=new TestRestTemplate();
	private String url = "http://localhost:8080/api/product/product";
	private HttpHeaders headers = new HttpHeaders();

	@Test
	public void octubre14_10() {
		testProducto(
				new ProductFindRequest("2020-06-14T10:00:00", 35455L, new BigDecimal("1")),
				new BigDecimal("35.40"));
	}
	@Test
	public void octubre14_16() {
		testProducto(
				new ProductFindRequest("2020-06-14T16:00:00", 35455L, new BigDecimal("1")),
				new BigDecimal("25.45"));
	}
	@Test
	public void octubre14_21() {
		testProducto(
				new ProductFindRequest("2020-06-14T21:00:00", 35455L, new BigDecimal("1")),
				new BigDecimal("35.40"));
	}
	@Test
	public void octubre15_10() {
		testProducto(
				new ProductFindRequest("2020-06-15T10:00:00", 35455L, new BigDecimal("1")),
				new BigDecimal("30.50"));
	}
	@Test
	public void octubre16_21() {
		testProducto(
				new ProductFindRequest("2020-06-16T21:00:00", 35455L, new BigDecimal("1")),
				new BigDecimal("38.95"));
	}

	public void testProducto(ProductFindRequest request,BigDecimal price){
		HttpEntity<ProductFindRequest> requestEntity = new HttpEntity<>(request, headers);
		ResponseEntity<ProductFindResponse> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, ProductFindResponse.class);

		// Realiza aserciones para verificar la respuesta
		ProductFindResponse product = response.getBody();
		// Realiza aserciones para verificar la respuesta
		assertEquals(200, response.getStatusCodeValue());
		assertNotNull(product);
		System.out.println(product.getPrice());
		assertEquals(price, product.getPrice());
	}

}
