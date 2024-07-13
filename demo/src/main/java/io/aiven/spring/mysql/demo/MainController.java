package io.aiven.spring.mysql.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(path = "/demo")

public class MainController{
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody User addNewUser(@RequestParam String name ,@RequestParam String email){
        User springUser = new User();
        springUser.setName(name);
        springUser.setEmail(email);
        userRepository.save(springUser);
        return springUser;
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}