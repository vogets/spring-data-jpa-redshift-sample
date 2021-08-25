package redshiftpoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import redshiftpoc.domain.Person;
import redshiftpoc.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Person> insertUser(@RequestBody Person person)
    {
        Person savedPerson=personRepository.save(person);
        return new ResponseEntity<>(savedPerson,HttpStatus.CREATED);
    }

    @GetMapping("/getPerson")
    public ResponseEntity<List<Person>> getAllUsers()
    {
        return new ResponseEntity<List<Person>>((List<Person>) personRepository.findAll(),HttpStatus.OK);
    }

}
