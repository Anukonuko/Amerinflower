package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/api/user")
    public String handleUserSubmission(@RequestBody User user) {
        System.out.println("User-Name: " + user.getName());
        System.out.println("Age: " + user.getAge());

        return "Received data";
    }

    @GetMapping("/api/user")
    public String getUserInfo() {
        return "called api";
    }
}
