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
    @PostMapping("/create")
    public Match read(@RequestBody Match match){
        return matchService.create(match);
    }
    @GetMapping("/read/{matchId}")
    public Match read(@PathVariable int matchId){
        return matchService.read(matchId);
    }
    @PostMapping("/update")
    public Match update(@RequestBody Match match){
        return matchService.update(match);
    }
    @GetMapping("/getall")
    public List<Match>getall(){
        return matchService.getAll();
    }
}
