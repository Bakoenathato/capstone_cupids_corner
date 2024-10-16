package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.match.Preference;
import za.ac.cput.service.match.PreferenceService;

import java.util.List;

@RestController
@RequestMapping("/preference")
public class PreferenceController {
    @Autowired
    private PreferenceService preferenceService;
    @PostMapping("/create")
    public Preference read(@RequestBody Preference preference){
        return preferenceService.create(preference);
    }
    @GetMapping("/read/{preferenceId}")
    public Preference read(@PathVariable long preferenceId ){
        return preferenceService.read(preferenceId);
    }
    @PostMapping("/update")
    public Preference update(@RequestBody Preference preference){
        return preferenceService.update(preference);
    }
    @GetMapping("/getall")
    public List<Preference> getall(){
        return preferenceService.getAll();
    }
}
