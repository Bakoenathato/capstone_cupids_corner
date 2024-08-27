package za.ac.cput.controller;

import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Swipe;
import za.ac.cput.service.SwipeService;

import java.util.List;

@RestController
@RequestMapping("/swipe")
public class SwipeController {
    @Autowired
    private SwipeService swipeService;

    @PostMapping("/create")
    public Swipe read(@RequestBody Swipe swipe){
        return swipeService.create(swipe);
    }
    @GetMapping("/read/{swipeId}")
    public Swipe read(@PathVariable long swipeId){
        return swipeService.read(swipeId);
    }
    @PostMapping("/update")
    public Swipe update(@RequestBody Swipe swipe){
        return swipeService.update(swipe);
    }
    @GetMapping("/getall")
    public List<Swipe>getall(){
        return swipeService.getAll();
    }


}
