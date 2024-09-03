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
    @JoinColumn(name = "swiper_id")
    private User swiper; // person who made the swipe

    @ManyToOne
    @JoinColumn(name = "swiped_id")
    private User swiped; // profile that was swiped on

    @Enumerated(EnumType.STRING)
    private SwipeDirection direction; // left or right swipe

    @Column(nullable = false)
    private Instant swipeTime; // timestamp of when the swipe occurred

    protected Swipe() {}

    private Swipe(Builder builder) {
        this.swipeId = builder.swipeId;
        this.swiper = builder.swiper;
        this.swiped = builder.swiped;
        this.direction = builder.direction;
        this.swipeTime = builder.swipeTime;
    }

    public long getSwipeId() {
        return swipeId;
    }

    public User getSwiper() {
        return swiper;
    }

    public User getSwiped() {
        return swiped;
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
        return getSwipeId() == swipe.getSwipeId() && Objects.equals(getSwiper(), swipe.getSwiper()) && Objects.equals(getSwiped(), swipe.getSwiped()) && getDirection() == swipe.getDirection() && Objects.equals(getSwipeTime(), swipe.getSwipeTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSwipeId(), getSwiper(), getSwiped(), getDirection(), getSwipeTime());
    }

    @Override
    public String toString() {
        return "Swipe{" +
                "swipeId=" + swipeId +
                ", swiper=" + swiper +
                ", swiped=" + swiped +
                ", direction=" + direction +
                ", swipeTime=" + swipeTime +
                '}';
    }

    public static class Builder {
        private long swipeId;
        private User swiper;
        private User swiped;
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

        public Builder setSwiper(User swiper) {
            this.swiper = swiper;
            return this;
        }

        public Builder setSwiped(User swiped) {
            this.swiped = swiped;
            return this;
        }

        public Builder setSwipeTime(Instant swipeTime) {
            this.swipeTime = swipeTime;
            return this;
        }

        public Builder copy(Swipe swipe) {
            this.swipeId = swipe.swipeId;
            this.swiper = swipe.swiper;
            this.swiped = swipe.swiped;
            this.direction = swipe.direction;
            this.swipeTime = swipe.swipeTime;
            return this;
        }

        public Swipe build() {
            return new Swipe(this);
        }
    }
}
