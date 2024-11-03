package com.example.demo;

import org.springframework.web.bind.annotation.*;



@RestController
public class UserController {
  
  @PostMapping("/api/user")
  public String handleUserSublission(@RequestBody User user) {
    System.out.println("User-Name:" + user.getName());
    System.out.println("Age:" + user.GetAge());

    return "Received data";
  }
}
