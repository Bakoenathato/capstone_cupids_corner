package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long likeID;

    @ManyToOne
    @JoinColumn(name = "liker_id", nullable = false)
    private UserProfile liker; // user profile that liked another profile

    @ManyToOne
    @JoinColumn(name = "liked_id", nullable = false)
    private UserProfile likedProfile; // the profile that was liked

    private LocalDateTime likedAt;

    protected Like(){

    }
    private Like (Builder builder){
        this.likeID=builder.likeID;
        this.liker = builder.liker;
        this.likedProfile = builder.likedProfile;
        this.likedAt = builder.likedAt;

    }

    public long getLikeID() {
        return likeID;
    }

    public UserProfile getLiker() {
        return liker;
    }

    public UserProfile getLikedProfile() {
        return likedProfile;
    }

    public LocalDateTime getLikedAt() {
        return likedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Like like)) return false;
        return getLikeID() == like.getLikeID() && Objects.equals(getLiker(), like.getLiker()) && Objects.equals(getLikedProfile(), like.getLikedProfile()) && Objects.equals(getLikedAt(), like.getLikedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLikeID(), getLiker(), getLikedProfile(), getLikedAt());
    }

    @Override
    public String toString() {
        return "Like{" +
                "likeID=" + likeID +
                ", liker=" + liker +
                ", likedProfile=" + likedProfile +
                ", likedAt=" + likedAt +
                '}';
    }

    public static class Builder{
        private long likeID;
        private UserProfile liker;
        private UserProfile likedProfile;
        private LocalDateTime likedAt;

        public Builder setLikeID(long likeID) {
            this.likeID = likeID;
            return this;
        }

        public Builder setLiker(UserProfile liker) {
            this.liker = liker;
            return this;
        }

        public Builder setLikedProfile(UserProfile likedProfile) {
            this.likedProfile = likedProfile;
            return this;
        }

        public Builder setLikedAt(LocalDateTime likedAt) {
            this.likedAt = likedAt;
            return this;
        }

        public Builder copy(Like like){
            this.likeID=like.likeID;
            this.liker=like.liker;
            this.likedProfile=like.likedProfile;
            this.likedAt=like.likedAt;
            return this;

        }
        public Like build(){
            return new Like (this);
        }

    }
}
