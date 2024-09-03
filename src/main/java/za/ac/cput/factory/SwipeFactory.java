package za.ac.cput.factory;

import za.ac.cput.domain.Swipe;
import za.ac.cput.domain.SwipeDirection;
import za.ac.cput.domain.User;

import java.time.Instant;

public class SwipeFactory {
    public static Swipe createSwipe(long swipeId, User swiper, User swipedProfile, SwipeDirection swipeDirection, Instant swipeTime) {
        if (swipeId <= 0 || swiper == null || swipedProfile == null || swipeDirection == null || swipeTime == null)
            return null;

        return new Swipe.Builder()
                .setSwipeId(swipeId)
                .setSwiper(swiper)
                .setSwiped(swipedProfile)
                .setDirection(swipeDirection)
                .setSwipeTime(swipeTime).
                build();
    }
}
