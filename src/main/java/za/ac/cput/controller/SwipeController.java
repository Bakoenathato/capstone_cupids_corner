package za.ac.cput.controller;

import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.api.SwipeUser;
import za.ac.cput.domain.Swipe;
import za.ac.cput.domain.SwipeDirection;
import za.ac.cput.domain.User;
import za.ac.cput.service.SwipeService;
import za.ac.cput.util.SwipeRequest;

import java.util.List;

@RestController
@RequestMapping("/swipe")
@CrossOrigin(origins = "http://localhost:5173")
public class SwipeController {

    private final SwipeService swipeService;
    private final SwipeUser swipeUser;

    @Autowired
    public SwipeController(SwipeService swipeService, SwipeUser swipeUser) {
        this.swipeService = swipeService;
        this.swipeUser = swipeUser;
    }

    @PostMapping("/action")
    public ResponseEntity<?> swipe(@RequestBody SwipeRequest swipeRequest) {
        User swiper = swipeRequest.getSwiper();
        User swiped = swipeRequest.getSwiped();
        SwipeDirection direction = swipeRequest.getDirection();

        swipeUser.swipe(swiper, swiped, direction);

        return ResponseEntity.ok("Success");
    }

    @GetMapping("/getall")
    public List<Swipe> getAll() {
        return swipeService.getAll();
    }

}
