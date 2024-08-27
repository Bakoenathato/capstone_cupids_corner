package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Like;
import za.ac.cput.service.LikeService;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping("create")
    public Like read(@RequestBody Like like){
        return likeService.create(like);
    }
    @GetMapping("/read/{likeID}")
    public Like read(@PathVariable Long likeID){
        return likeService.read(likeID);
    }
    @PostMapping("/update")
    public Like update(@RequestBody Like like){
        return likeService.update(like);
    }
    @GetMapping("/getall")
    public List<Like> getall(){
        return likeService.getAll();
    }
}
