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
    private String profileID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
    private User userID;

    private String Interests;

    private boolean profile_visibility;

    private LocalDateTime created_at;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locationID")
    protected Location location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "preferenceID")
    private Preference preferenceID;

    @OneToMany(mappedBy = "likedProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Like> receivedLikes = new HashSet<>();

    @OneToMany(mappedBy = "profile1", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Match> matchRequest = new HashSet<>();

    @OneToMany(mappedBy = "profile2", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Match> matchedAccepted = new HashSet<>();

    @OneToMany(mappedBy = "swiper", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Swipe> swipes;

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
        this.matchRequest = builder.matchRequest;
        this.matchedAccepted = builder.matchedAccepted;
        this.swipes = builder.swipes;
    }

    public String getProfileID() {
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

    public Set<Match> getMatchRequest() {
        return matchRequest;
    }

    public Set<Match> getMatchedAccepted() {
        return matchedAccepted;
    }

    public List<Swipe> getSwipes() {
        return swipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserProfile profile)) return false;
        return isProfile_visibility() == profile.isProfile_visibility() && Objects.equals(getProfileID(), profile.getProfileID()) && Objects.equals(getUserID(), profile.getUserID()) && Objects.equals(getInterests(), profile.getInterests()) && Objects.equals(getCreated_at(), profile.getCreated_at()) && Objects.equals(getLocation(), profile.getLocation()) && Objects.equals(getPreferenceID(), profile.getPreferenceID()) && Objects.equals(getReceivedLikes(), profile.getReceivedLikes()) && Objects.equals(getMatchRequest(), profile.getMatchRequest()) && Objects.equals(getMatchedAccepted(), profile.getMatchedAccepted()) && Objects.equals(getSwipes(), profile.getSwipes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProfileID(), getUserID(), getInterests(), isProfile_visibility(), getCreated_at(), getLocation(), getPreferenceID(), getReceivedLikes(), getMatchRequest(), getMatchedAccepted(), getSwipes());
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "profileID='" + profileID + '\'' +
                ", userID=" + userID +
                ", Interests='" + Interests + '\'' +
                ", profile_visibility=" + profile_visibility +
                ", created_at=" + created_at +
                ", location=" + location +
                ", preferenceID=" + preferenceID +
                ", receivedLikes=" + receivedLikes +
                ", matchRequest=" + matchRequest +
                ", matchedAccepted=" + matchedAccepted +
                ", swipes=" + swipes +
                '}';
    }

    public static class Builder {
        private String profileID;
        private User userID;
        private String Interests;
        private boolean profile_visibility;
        private LocalDateTime created_at;
        private Location location;
        private Preference preferenceID;
        private Set<Like> receivedLikes;
        private Set<Match> matchRequest;
        private Set<Match> matchedAccepted;
        private List<Swipe> swipes;

        public Builder setProfileID(String profileID) {
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

        public Builder setMatchRequest(Set<Match> matchRequest) {
            this.matchRequest = matchRequest;
            return this;
        }

        public Builder setMatchedAccepted(Set<Match> matchedAccepted) {
            this.matchedAccepted = matchedAccepted;
            return this;
        }

        public Builder setSwipes(List<Swipe> swipes) {
            this.swipes = swipes;
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
        this.matchRequest=e.matchRequest;
        this.matchedAccepted=e.matchedAccepted;
        this.swipes=e.swipes;
        return this;
    }

    public UserProfile build() {
        return new UserProfile(this);
    }
}

}

