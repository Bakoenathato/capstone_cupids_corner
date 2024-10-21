package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.user.User;
import za.ac.cput.service.user.UserService;
import za.ac.cput.dto.LoginDTO;
import za.ac.cput.dto.LoginResponse;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/admin/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        try {
            User createdUser = userService.create(user);
            return ResponseEntity.ok(createdUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/read")
    public ResponseEntity<?> readCurrent(Authentication authentication) {
        String username = authentication.getName();

        User user = userService.readCurrent(username);

        return ResponseEntity.ok(user);
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin/read/{userId}")
    public User read(@PathVariable long userId){
        return userService.read(userId);
    }

    //@PreAuthorize("hasRole(
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/getall")
    public List<User>getall(){
        return userService.getAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User userInput){
        try {
            User createdUser = userService.register(userInput);
            return ResponseEntity.ok(createdUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.verify(user);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping("/logout")
    public ResponseEntity<?> logout(){
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("Logged out successfully");
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
//        LoginResponse loginResponse = userService.loginUser(loginDTO);
//        return ResponseEntity.ok(loginResponse);
//    }


    //@PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id, Authentication authentication) {
        System.out.println(authentication.getAuthorities());
        boolean deleteUser = userService.delete(id);
        return new ResponseEntity<>(deleteUser, HttpStatus.OK);
//        try {
//            userService.delete(userId); // Assuming this service method deletes the user
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 if successful
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if the user is not found
//        }
    }


}
