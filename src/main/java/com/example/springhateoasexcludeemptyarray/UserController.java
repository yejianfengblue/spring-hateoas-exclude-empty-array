package com.example.springhateoasexcludeemptyarray;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    @GetMapping(path = "/user/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> getOne(@PathVariable(name = "username") String username,
                                @RequestParam(name = "isWithSelfLink", defaultValue = "true") boolean isWithSelfLink) {

        User user = new User(username);
        if (isWithSelfLink) {
            user.add(linkTo(methodOn(UserController.class).getOne(username, true)).withSelfRel());
        }

        return ResponseEntity.ok(user);
    }

}
