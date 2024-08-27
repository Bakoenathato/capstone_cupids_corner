package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
public class Swipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long swipeId;

    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile swiper; // person who performed the swipe

    @ManyToOne
    @JoinColumn(name = "swiped_profile_id")
    private UserProfile swipedProfile; // profile that was swiped on

    @Enumerated(EnumType.STRING)
    private SwipeDirection direction; // left or right swipe

    @Column(nullable = false)
    private Instant swipeTime; // timestamp of when the swipe occurred

    protected Swipe() {}

    private Swipe(Builder builder) {
        this.swipeId = builder.swipeId;
        this.swiper = builder.swiper;
        this.swipedProfile = builder.swipedProfile;
        this.direction = builder.direction;
        this.swipeTime = builder.swipeTime;
    }

    public long getSwipeId() {
        return swipeId;
    }

    public UserProfile getSwiper() {
        return swiper;
    }

    public UserProfile getSwipedProfile() {
        return swipedProfile;
    }

    public SwipeDirection getDirection() {
        return direction;
    }

    public Instant getSwipeTime() {
        return swipeTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Swipe swipe)) return false;
        return getSwipeId() == swipe.getSwipeId() && Objects.equals(getSwiper(), swipe.getSwiper()) && Objects.equals(getSwipedProfile(), swipe.getSwipedProfile()) && getDirection() == swipe.getDirection() && Objects.equals(getSwipeTime(), swipe.getSwipeTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSwipeId(), getSwiper(), getSwipedProfile(), getDirection(), getSwipeTime());
    }

    @Override
    public String toString() {
        return "Swipe{" +
                "swipeId=" + swipeId +
                ", swiper=" + swiper +
                ", swipedProfile=" + swipedProfile +
                ", direction=" + direction +
                ", swipeTime=" + swipeTime +
                '}';
    }

    public static class Builder {
        private long swipeId;
        private UserProfile swiper;
        private UserProfile swipedProfile;
        private SwipeDirection direction;
        private Instant swipeTime;

        public Builder setDirection(SwipeDirection direction) {
            this.direction = direction;
            return this;
        }

        public Builder setSwipeId(long swipeId) {
            this.swipeId = swipeId;
            return this;
        }

        public Builder setSwiper(UserProfile swiper) {
            this.swiper = swiper;
            return this;
        }

        public Builder setSwipedProfile(UserProfile swipedProfile) {
            this.swipedProfile = swipedProfile;
            return this;
        }

        public Builder setSwipeTime(Instant swipeTime) {
            this.swipeTime = swipeTime;
            return this;
        }

        public Builder copy(Swipe swipe) {
            this.swipeId = swipe.getSwipeId();
            this.swiper = swipe.getSwiper();
            this.swipedProfile = swipe.getSwipedProfile();
            this.direction = swipe.getDirection();
            this.swipeTime = swipe.getSwipeTime();
            return this;
        }

        public Swipe build() {
            return new Swipe(this);
        }
    }
}
