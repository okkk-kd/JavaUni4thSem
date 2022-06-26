package com;

import com.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dogs")
public class DogController {
    @Qualifier("userService")
    DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Dog>> getAllDogs() {
        final List<Dog> dogs = dogService.readAll();
        return dogs != null ? new ResponseEntity<>(dogs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Dog> getDog(@PathVariable(name = "id") long id) {
        final Dog dog = dogService.read(id);
        return dog != null
                ? new ResponseEntity<>(dog, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //curl -i -X POST -H "Content-Type: application/json" -d "{\"id\":3,\"name\":\"Berny\",\"breed\":\"Bulldog\",\"user_id\":3}" http://localhost:8001/dogs
    @PostMapping(value = "")
    public ResponseEntity<?> addDog(@RequestBody Dog dog) {
        dogService.saveDog(dog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Dog dog) {
        final boolean updated = dogService.update(dog, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteDog(@PathVariable(name = "id") long id) {
        final boolean deleted = dogService.deleteDog(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/filter/name/{name}")
    public ResponseEntity<List<Dog>> getAllDogsByName(@PathVariable(name = "name") String name) {
        final List<Dog> dogs = dogService.findDogsByName(name);
        return dogs != null && !dogs.isEmpty()
                ? new ResponseEntity<>(dogs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/filter/breed/{breed}")
    public ResponseEntity<List<Dog>> getAllDogsByBreed(@PathVariable(name = "breed") String breed) {
        final List<Dog> dogs = dogService.findDogsByBreed(breed);
        return dogs != null && !dogs.isEmpty()
                ? new ResponseEntity<>(dogs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
