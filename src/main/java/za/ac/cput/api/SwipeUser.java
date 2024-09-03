package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Swipe;
import za.ac.cput.domain.SwipeDirection;
import za.ac.cput.domain.User;
import za.ac.cput.repository.SwipeRepository;
import za.ac.cput.service.MatchService;

@Service
public class SwipeUser {

    private final SwipeRepository swipeRepository;
    private final MatchService matchService;

    @Autowired
    public SwipeUser(SwipeRepository swipeRepository, MatchService matchService) {
        this.swipeRepository = swipeRepository;
        this.matchService = matchService;
    }

    public void swipe(User swiper, User swiped, SwipeDirection direction) {
        Swipe swipe = new Swipe.Builder()
                .setSwiper(swiper)
                .setSwiped(swiped)
                .setDirection(direction)
                .build();

        swipeRepository.save(swipe);

        if (direction == SwipeDirection.RIGHT) {
            checkForMatch(swiper, swiped);
        }
    }

    public void checkForMatch(User swiper, User swiped) {
        boolean user2SwipedRightOnUser1 = swipeRepository.existsBySwiper_UserIdAndSwiped_UserIdAndDirection
                (swiper.getUserId(), swiped.getUserId(), SwipeDirection.RIGHT);

        if (user2SwipedRightOnUser1) {
            matchService.createMatch(swiper, swiped);
        }
    }
}
