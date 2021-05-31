package com.example.reservationsystem.user;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User save(@RequestBody User client) {
        return userService.save(client);
    }

//    @GetMapping("/user")
//    public

    @Secured({"ROLE_CLIENT", "ROLE_ADMIN"})
    public List<User> getAll(){
        return userService.getAll();
    }
}
