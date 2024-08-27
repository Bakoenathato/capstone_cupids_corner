package za.ac.cput.domain;

/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import jakarta.persistence.*;

import java.util.Objects;

// unique constraint to prevent duplicate matches.
@Entity
@Table(name = "matches", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"profileID_1", "profileID2"})
})
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;

    @ManyToOne
    @JoinColumn(name = "profileID_1")
    private UserProfile profile1;

    @ManyToOne
    @JoinColumn(name = "profileID_2")
    private UserProfile profile2;

    protected Match() {
    }

    protected Match(Builder builder) {
        this.matchId = builder.matchId;
        this.profile1 = builder.profile1;
        this.profile2 = builder.profile2;
    }

    public int getMatchId() {
        return matchId;
    }

    public UserProfile getProfile1() {
        return profile1;
    }

    public UserProfile getProfile2() {
        return profile2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match match)) return false;
        return getMatchId() == match.getMatchId() && Objects.equals(getProfile1(), match.getProfile1()) && Objects.equals(getProfile2(), match.getProfile2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatchId(), getProfile1(), getProfile2());
    }

    @Override
    public String
    toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", profile1=" + profile1 +
                ", profile2=" + profile2 +
                '}';
    }

    public static class Builder {
        private int matchId;
        private UserProfile profile1;
        private UserProfile profile2;

        public Builder setMatchId(int matchId) {
            this.matchId = matchId;
            return this;
        }

        public Builder setProfile1(UserProfile profile1) {
            this.profile1 = profile1;
            return this;
        }

        public Builder setProfile2(UserProfile profile2) {
            this.profile2 = profile2;
            return this;
        }

        public Builder copy(Match match){
            this.setMatchId(match.getMatchId());
            this.setProfile1(match.getProfile1());
            this.setProfile2(match.getProfile2());
            return this;
        }

        public Match build() {
            return new Match(this);
        }
    }
}
