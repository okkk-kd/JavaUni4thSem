package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    @Qualifier("userService")
    UserService service;

    @GetMapping(value = "")
    public ResponseEntity<List<User>> getFull() {
        final List<User> usrs = service.getUsers();
        return usrs != null ? new ResponseEntity<>(usrs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") long id) {
        final User user = service.read(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //curl -i -X POST -H "Content-Type: application/json" -d "{\"id\":4,\"firstName\":\"Danny\",\"lastName\":\"Andrews\"}" http://localhost:8000/users
    @PostMapping(value = "")
    public ResponseEntity<?> addUser(@RequestBody User us) {
        service.saveUser(us);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = service.deleteUser(service.read(id));
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/filter/{field}={value}")
    public ResponseEntity<List<User>> usersFilter(@PathVariable(name = "field") String field, @PathVariable(name = "value") String value) {
        final List<User> usrs = service.userFilter(field, value);
        return usrs != null && !usrs.isEmpty()
                ? new ResponseEntity<>(usrs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
