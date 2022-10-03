package tech.julkrolon.SpringBootAngular.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.julkrolon.SpringBootAngular.entities.User;
import tech.julkrolon.SpringBootAngular.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return userService.getUsersFromDB();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user){
        userService.saveUser(user);
    }

}
