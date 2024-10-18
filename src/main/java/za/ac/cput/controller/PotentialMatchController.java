package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dto.MatchDTO;
import za.ac.cput.dto.SwipeDTO;
import za.ac.cput.service.match.PotentialMatchService;

@RestController
@CrossOrigin
@RequestMapping("/api/potential-match")
public class PotentialMatchController {

    private final PotentialMatchService potentialMatchService;

    @Autowired
    public PotentialMatchController(PotentialMatchService potentialMatchService) {
        this.potentialMatchService = potentialMatchService;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/process-swipe")
    public MatchDTO processSwipe(@RequestBody SwipeDTO swipeDTO) {
        return potentialMatchService.processSwipe(swipeDTO);
    }
}
