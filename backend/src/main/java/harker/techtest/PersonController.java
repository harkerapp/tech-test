package harker.techtest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    private final String peoplePath = "/people";

    @GetMapping(peoplePath)
    public List<Person> getPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(peoplePath + "/{id}")
    public Person getPerson(@PathVariable("id") String id) {
        return personService.getPerson(id);
    }

    @PostMapping(peoplePath)
    public Person postPerson(@RequestBody Person personModel) {
        return personService.postPerson(personModel);
    }

    @PutMapping(peoplePath)
    public Person putPerson(@RequestBody Person personModel) {
        return personService.putPerson(personModel);
    }
    
}
