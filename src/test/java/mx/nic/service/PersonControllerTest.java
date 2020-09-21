package mx.nic.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
public class PersonControllerTest {
	@Inject
	@Client("/")
	RxHttpClient client;
	
	@Test
	public void testPerson() {
		HttpRequest<String> request = HttpRequest.GET("/person");
		String body = client.toBlocking().retrieve(request );
		
		assertNotNull(body);
		assertEquals("Person", body);
	}
}
