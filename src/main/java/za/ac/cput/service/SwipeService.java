package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Swipe;
import za.ac.cput.repository.SwipeRepository;

import java.util.List;

@Service
public class SwipeService implements ISwipeService {

    private SwipeRepository swipeRepository;

    @Autowired
    public SwipeService(SwipeRepository swipeRepository) {
        this.swipeRepository = swipeRepository;
    }

    @Override
    public Swipe create(Swipe swipe) {
        return swipeRepository.save(swipe);
    }

    @Override
    public Swipe read(Long swipeId){
        return swipeRepository.findById(swipeId).orElse(null);
    }

    @Override
    public Swipe update(Swipe swipe){
        return swipeRepository.save(swipe);
    }

    @Override
    public void delete(Long swipeId){
        swipeRepository.deleteById(swipeId);
    }

    @Override
    public List<Swipe> getAll(){
        return swipeRepository.findAll();
    }
}
