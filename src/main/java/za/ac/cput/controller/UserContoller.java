package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;

import java.util.List;

@RestController
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

    public ResponseEntity<?> addUserWithImage(@RequestPart User user, @RequestPart MultipartFile imageFile) {
        try {
            User savedUser = userService.addUserWithImage(user, imageFile);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @PostMapping("/addWithBase64Image")
//    public ResponseEntity<?> addUserWithBase64Image(@RequestBody User user, @RequestParam String base64Image) {
//        try {
//            User savedUser = userService.addUserWithBase64Image(user, base64Image);
//            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
