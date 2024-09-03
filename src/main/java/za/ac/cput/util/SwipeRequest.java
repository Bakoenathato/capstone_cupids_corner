package za.ac.cput.util;

import za.ac.cput.domain.SwipeDirection;
import za.ac.cput.domain.User;

public class SwipeRequest {
    private User swiper;
    private User swiped;
    private SwipeDirection direction;

    public User getSwiper() {
        return swiper;
    }

    public void setSwiper(User swiper) {
        this.swiper = swiper;
    }

    public User getSwiped() {
        return swiped;
    }

    public void setSwiped(User swiped) {
        this.swiped = swiped;
    }

    public SwipeDirection getDirection() {
        return direction;
    }

    public void setDirection(SwipeDirection direction) {
        this.direction = direction;
    }
}
