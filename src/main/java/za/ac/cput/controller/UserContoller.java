package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;
import za.ac.cput.util.LoginDTO;
import za.ac.cput.util.LoginResponse;

import java.util.List;

@RestController
//@CrossOrigin
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")

public class UserContoller {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User read(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping("/read/{userId}")
    public User read(@PathVariable long userId){
        return userService.read(userId);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @GetMapping("/getall")
    public List<User>getall(){
        return userService.getAll();
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
