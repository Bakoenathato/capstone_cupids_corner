package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.match.PotentialMatch;
import za.ac.cput.dto.MatchDTO;
import za.ac.cput.dto.SwipeDTO;
import za.ac.cput.service.match.PotentialMatchService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/potential-match")
public class PotentialMatchController {

    private final PotentialMatchService potentialMatchService;

    @Autowired
    public PotentialMatchController(PotentialMatchService potentialMatchService) {
        this.potentialMatchService = potentialMatchService;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping("/process-swipe")
    public MatchDTO processSwipe(@RequestBody SwipeDTO swipeDTO) {
        return potentialMatchService.processSwipe(swipeDTO);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/admin/getall")
    public List<PotentialMatch> getAllPotentialMatches() {
        return potentialMatchService.getAll();
    }
}
