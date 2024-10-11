package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.dto.MatchDTO;
import za.ac.cput.dto.SwipeDTO;
import za.ac.cput.service.PotentialMatchService;

@RestController
@RequestMapping("/api/potential-match")
public class PotentialMatchController {

    private final PotentialMatchService potentialMatchService;

    @Autowired
    public PotentialMatchController(PotentialMatchService potentialMatchService) {
        this.potentialMatchService = potentialMatchService;
    }

    @PostMapping("/process-swipe")
    public MatchDTO processSwipe(@RequestBody SwipeDTO swipeDTO) {
        return potentialMatchService.processSwipe(swipeDTO);
    }
}
