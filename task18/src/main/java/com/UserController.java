package com;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Qualifier("userService")
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<User>> getAllUsers() {
        final List<User> usrs = userService.readAll();
        return usrs != null ? new ResponseEntity<>(usrs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable(name = "id") long id) {
        final User user = userService.read(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //curl -i -X POST -H "Content-Type: application/json" -d "{\"id\":5,\"firstName\":\"Steven\",\"lastName\":\"Spencer\"}" http://localhost:8001/users
    @PostMapping(value = "")
    public ResponseEntity<?> addUser(@RequestBody User us) {
        userService.saveUser(us);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody User user) {
        final boolean updated = userService.update(user, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") long id) {
        final boolean deleted = userService.deleteUser(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/filter/firstName/{firstName}")
    public ResponseEntity<List<User>> getAllUsersByFirstName(@PathVariable(name = "firstName") String firstName) {
        final List<User> usrs = userService.findUsersByFirstName(firstName);
        return usrs != null && !usrs.isEmpty()
                ? new ResponseEntity<>(usrs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/filter/lastName/{lastName}")
    public ResponseEntity<List<User>> getAllUsersByLastName(@PathVariable(name = "lastName") String lastName) {
        final List<User> usrs = userService.findUsersByLastName(lastName);
        return usrs != null && !usrs.isEmpty()
                ? new ResponseEntity<>(usrs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
