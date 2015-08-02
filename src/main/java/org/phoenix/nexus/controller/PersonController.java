package org.phoenix.nexus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.phoenix.nexus.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/nexus")
public class PersonController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/person/{id}")
    public Person retrievePerson(@RequestParam(value="name", defaultValue="World") String name) {
		
        return new Person(counter.incrementAndGet(), name);
    }
	
	@RequestMapping("/person")
    public List<Person> retrievePerson() {
		
		List<Person> list = new ArrayList<Person>();
		
		list.add(new Person(counter.incrementAndGet(), "hello"));
		list.add(new Person(counter.incrementAndGet(), "world"));
		
        return list;
    }
}
