package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Match;
import za.ac.cput.service.MatchService;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService matchService;


    @GetMapping("/getall")
    public List<Match>getAll(){
        return matchService.getAll();
    }
}
