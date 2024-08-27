package za.ac.cput.domain;

/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_preference")
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long preferenceId;

    @OneToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private UserProfile profile;

    private int minAge;
    private int maxAge;

    private int maxDistance;

    @Enumerated(EnumType.STRING)
    private Gender genderPreference;

    protected Preference() {

    }

    private Preference(Builder builder){
        this.preferenceId = builder.preferenceId;
        this.profile = builder.profile;
        this.minAge = builder.minAge;
        this.maxAge = builder.maxAge;
        this.maxDistance = builder.maxDistance;
        this.genderPreference = builder.genderPreference;
    }

    public long getPreferenceId() {
        return preferenceId;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public Gender getGenderPreference() {
        return genderPreference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Preference that)) return false;
        return getPreferenceId() == that.getPreferenceId() && getMinAge() == that.getMinAge() && getMaxAge() == that.getMaxAge() && getMaxDistance() == that.getMaxDistance() && Objects.equals(getProfile(), that.getProfile()) && getGenderPreference() == that.getGenderPreference();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPreferenceId(), getProfile(), getMinAge(), getMaxAge(), getMaxDistance(), getGenderPreference());
    }

    @Override
    public String toString() {
        return "Preference{" +
                "preferenceId=" + preferenceId +
                ", profile=" + profile +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", maxDistance=" + maxDistance +
                ", genderPreference=" + genderPreference +
                '}';
    }

    public static class Builder {
        private long preferenceId;
        private UserProfile profile;
        private int minAge;
        private int maxAge;
        private int maxDistance;
        private Gender genderPreference;

        public Builder setPreferenceId(long preferenceId) {
            this.preferenceId = preferenceId;
            return this;
        }

        public Builder setProfile(UserProfile profile) {
            this.profile = profile;
            return this;
        }

        public Builder setMinAge(int minAge) {
            this.minAge = minAge;
            return this;
        }

        public Builder setMaxAge(int maxAge) {
            this.maxAge = maxAge;
            return this;
        }

        public Builder setMaxDistance(int maxDistance) {
            this.maxDistance = maxDistance;
            return this;
        }

        public Builder setGenderPreference(Gender genderPreference) {
            this.genderPreference = genderPreference;
            return this;
        }

        public Builder copy(Preference p) {
            this.preferenceId = p.preferenceId;
            this.profile = p.profile;
            this.minAge = p.minAge;
            this.maxAge = p.maxAge;
            this.maxDistance = p.maxDistance;
            this.genderPreference = p.genderPreference;
            return this;
        }

        public Preference build() {
            return new Preference(this);
        }
    }
}
