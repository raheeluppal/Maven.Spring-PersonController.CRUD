package Controllers;

import Model.Person;
import Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {


    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @RequestMapping("/people")
    public Person createPerson(@RequestBody Person p){

        return personRepository.save(p);
    }

    @RequestMapping("/people{id}")
    public Person getPerson(@PathVariable Long id){

        return personRepository.findOne(id);
    }

    @RequestMapping("/people")
    public List<Person> getPersonList(){

        return (List<Person>) personRepository.findAll();
    }

    @RequestMapping("/people")
    public Person updatePerson(@RequestBody Person p){

        return null;
    }

    @RequestMapping("/people{id}")
    public void DeletePerson(@PathVariable Long id){
        personRepository.delete(id);
    }

}
