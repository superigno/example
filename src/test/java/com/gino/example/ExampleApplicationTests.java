package com.gino.example;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ExampleApplicationTests {

	@LocalServerPort
	private int randomServerPort;
	
	@Test
	public void testSearch() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    String baseUrl = "http://localhost:" + randomServerPort + "/counter-api/search";
	    URI uri = new URI(baseUrl);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Authorization", "Basic " + "b3B0dXM6Y2FuZGlkYXRlcw==");
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    String data = "{\"searchText\":[\"Duis\", \"Sed\", \"Donec\", \"Augue\", \"Pellentesque\", \"123\"]}";
	    HttpEntity<String> request = new HttpEntity<String>(data, headers);
	 
	    ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
	     
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    
	}
	
	@Test
	public void testCountText() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    String baseUrl = "http://localhost:" + randomServerPort + "/counter-api/top/20";
	    URI uri = new URI(baseUrl);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Authorization", "Basic " + "b3B0dXM6Y2FuZGlkYXRlcw==");
	    HttpEntity<String> request = new HttpEntity<String>(headers);
	 
	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
	  	    
	    Assert.assertEquals(200, result.getStatusCodeValue());
	}

}
