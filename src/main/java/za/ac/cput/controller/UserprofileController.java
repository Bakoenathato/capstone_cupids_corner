package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.service.UserService;
import za.ac.cput.service.UserprofileService;

import java.util.List;

@RestController
@RequestMapping("/userprofile")
public class UserprofileController {

    @Autowired
    private UserprofileService userprofileService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UserProfile read(@RequestBody UserProfile userProfile){
        return userprofileService.create(userProfile);
    }

    @GetMapping("/read/{profileID}")
    public UserProfile read(@PathVariable Integer profileID){
        return userprofileService.read(profileID);
    }
    @PostMapping("/update")
    public UserProfile update(@RequestBody UserProfile userProfile){
        return userprofileService.update(userProfile);
    }

    @GetMapping("/getall")
    public List<UserProfile>getall(){
        return userprofileService.getAll();
    }



}
