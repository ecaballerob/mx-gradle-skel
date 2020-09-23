package mx.nic.service.test.controller;

import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import mx.nic.service.model.Person;

@MicronautTest
@SuppressWarnings("resource")
public class PersonControllerTest {
    @Inject
    EmbeddedServer server;
    
    @Test
    public void testAdd() throws MalformedURLException {
		HttpClient client = HttpClient.create(new URL("http://" + server.getHost() + ":" + server.getPort()));
    	Person person = new Person();
    	person.setName("Emilio");
    	person.setEmail("email@mail.mx");
        person = client.toBlocking().retrieve(HttpRequest.POST("/person", person), Person.class);
        Assertions.assertNotNull(person);
        Assertions.assertEquals(Integer.valueOf(1), person.getId());
    }
    
    @Test
    public void testFindAll() throws MalformedURLException {
        HttpClient client = HttpClient.create(new URL("http://" + server.getHost() + ":" + server.getPort()));
        Person[] persons = client.toBlocking().retrieve(HttpRequest.GET("/person"), Person[].class);
        Assertions.assertEquals(1, persons.length);
    }
    

    
}