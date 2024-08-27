package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Like;
import za.ac.cput.domain.Location;
import za.ac.cput.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping("/create")
    public Location read(@RequestBody Location location){
        return locationService.create(location);
    }
    @GetMapping("/read/{postalCode}")
    public Location read(@PathVariable Long postalCode){
        return locationService.read(postalCode);
    }
    @PostMapping("/update")
    public Location update(@RequestBody Location location){
        return locationService.update(location);
    }
    @GetMapping("/getall")
    public List<Location> getall(){
        return locationService.getAll();
    }

}
