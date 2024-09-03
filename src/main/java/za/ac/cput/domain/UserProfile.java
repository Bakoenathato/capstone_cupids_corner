package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

//UserProfile.java
//UserProfile model class
//Author:Braedon Sidney Mullins(222821825)
//Date:27 March 2024


@Entity
@DiscriminatorValue("userprofile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileID;

    @OneToOne
    @JoinColumn(name = "userID", nullable = false)
    private User userID;

    private String Interests;

    private boolean profile_visibility;

    private LocalDateTime created_at;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locationID", nullable = true)
    protected Location location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "preferenceID", nullable = true)
    private Preference preferenceID;

    @OneToMany(mappedBy = "likedProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Like> receivedLikes = new HashSet<>();


    protected UserProfile() {
    }

    protected UserProfile(Builder builder) {
        this.profileID = builder.profileID;
        this.userID = builder.userID;
        this.Interests = builder.Interests;
        this.profile_visibility = builder.profile_visibility;
        this.created_at = builder.created_at;
        this.location = builder.location;
        this.preferenceID = builder.preferenceID;;
        this.receivedLikes = builder.receivedLikes;
    }

    public int getProfileID() {
        return profileID;
    }

    public User getUserID() {
        return userID;
    }

    public String getInterests() {
        return Interests;
    }

    public boolean getProfile_visibility() {
        return profile_visibility;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public Location getLocation() {
        return location;
    }

    public Set<Like> getReceivedLikes() {
        return receivedLikes;
    }

    public boolean isProfile_visibility() {
        return profile_visibility;
    }

    public Preference getPreferenceID() {
        return preferenceID;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProfile that)) return false;
        return getProfileID() == that.getProfileID() && isProfile_visibility() == that.isProfile_visibility() && Objects.equals(getUserID(), that.getUserID()) && Objects.equals(getInterests(), that.getInterests()) && Objects.equals(getCreated_at(), that.getCreated_at()) && Objects.equals(getLocation(), that.getLocation()) && Objects.equals(getPreferenceID(), that.getPreferenceID()) && Objects.equals(getReceivedLikes(), that.getReceivedLikes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProfileID(), getUserID(), getInterests(), isProfile_visibility(), getCreated_at(), getLocation(), getPreferenceID(), getReceivedLikes());
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "profileID=" + profileID +
                ", userID=" + userID +
                ", Interests='" + Interests + '\'' +
                ", profile_visibility=" + profile_visibility +
                ", created_at=" + created_at +
                ", location=" + location +
                ", preferenceID=" + preferenceID +
                ", receivedLikes=" + receivedLikes +
                '}';
    }

    public static class Builder {
        private int profileID;
        private User userID;
        private String Interests;
        private boolean profile_visibility;
        private LocalDateTime created_at;
        private Location location;
        private Preference preferenceID;
        private Set<Like> receivedLikes;

        public Builder setProfileID(int profileID) {
            this.profileID = profileID;
            return this;
        }

        public Builder setUserID(User userID) {
            this.userID = userID;
            return this;
        }

        public Builder setInterests(String interests) {
            Interests = interests;
            return this;
        }

        public Builder setProfile_visibility(boolean profile_visibility) {
            this.profile_visibility = profile_visibility;
            return this;
        }

        public Builder setCreated_at(LocalDateTime created_at) {
            this.created_at = created_at;
            return this;
        }

        public Builder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public Builder setPreferenceID(Preference preferenceID) {
            this.preferenceID = preferenceID;
            return this;
        }

        public Builder setReceivedLikes(Set<Like> receivedLikes) {
            this.receivedLikes = receivedLikes;
            return this;
        }


        public Builder copy(UserProfile e) {
        this.profileID = e.profileID;
        this.userID = e.userID;
        this.Interests = e.Interests;
        this.profile_visibility = e.profile_visibility;
        this.created_at = e.created_at;
        this.location= e.location;
        this.preferenceID=e.preferenceID;
        this.receivedLikes=e.receivedLikes;
        return this;
    }

    public UserProfile build() {
        return new UserProfile(this);
    }
}

}

