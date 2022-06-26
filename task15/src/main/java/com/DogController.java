package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dogs")
public class DogController {
    @Autowired
    @Qualifier("dogService")
    DogService service;

    @GetMapping(value = "/{dogId}/user")
    public ResponseEntity<User> getDogUser(@PathVariable(name = "dogId") Long dogId) {
        final User user = service.getUserByDog(dogId);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Dog>> getFull() {
        return service.getDogs() != null ? new ResponseEntity<>(service.getDogs(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Dog> read(@PathVariable(name = "id") long id) {
        final Dog dog = service.read(id);
        return dog != null
                ? new ResponseEntity<>(dog, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/filter/{field}={value}")
    public ResponseEntity<List<Dog>> dogsFilter(@PathVariable(name = "field") String field, @PathVariable(name = "value") String value) {
        final List<Dog> dogs = service.dogFilter(field, value);
        return dogs != null && !dogs.isEmpty()
                ? new ResponseEntity<>(dogs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //curl -i -X POST -H "Content-Type: application/json" -d "{\"id\":3,\"name\":\"Berny\",\"breed\":\"Bulldog\",\"user_id\":3}" http://localhost:8000/dogs
    @PostMapping(value = "")
    public ResponseEntity<?> addDog(Dog dog) {
        service.saveDog(dog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
