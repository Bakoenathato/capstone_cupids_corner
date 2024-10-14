package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;
import za.ac.cput.dto.LoginDTO;
import za.ac.cput.dto.LoginResponse;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:5173")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        try {
            User createdUser = userService.create(user);
            return ResponseEntity.ok(createdUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
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
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId) {
        try {
            userService.delete(userId); // Assuming this service method deletes the user
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 if successful
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if the user is not found
        }
    }

}
