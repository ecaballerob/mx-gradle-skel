package mx.nic.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import mx.nic.service.model.Person;

@Controller("/person")
public class PersonController {
	List<Person> people = new ArrayList<>();
	
	@Post
	public Person add(@Body Person person) {
		person.setId(people.size() + 1);
		people.add(person);
		return person;
	}
	
    @Get("{?max,offset}")
    public List<Person> findAll(@Nullable Integer max, @Nullable Integer offset) {
        return people.stream()
                .skip(offset == null ? 0 : offset)
                .limit(max == null ? 10000 : max)
                .collect(Collectors.toList());
    }
    


}
