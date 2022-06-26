package com;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class GroupController {
    private Group group;

    @GetMapping("/group")
    public String get() {
        return group == null ? "nullo" : group.toString();
    }

    //curl -i -X POST -H "Content-Type: application/json" -d "{\"groupName\":\"IKBO\"}" http://localhost:8080/group
    @PostMapping(
            path = "/group",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    "application/json"
            }
    )
    public void set(@Valid @RequestBody Group group) {
        this.group = group;
    }

    // curl -X DELETE localhost:8080/group
    @DeleteMapping("/group")
    public void delete() {
        group = null;
    }
}
