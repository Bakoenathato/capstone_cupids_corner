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
        @UniqueConstraint(columnNames = {"profileID_1", "profileID_2"})
})
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matchId;

    @ManyToOne
    @JoinColumn(name = "profileID_1", referencedColumnName = "userID")
    private User profile1;

    @ManyToOne
    @JoinColumn(name = "profileID_2", referencedColumnName = "userID")
    private User profile2;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    protected Match() {
    }

    protected Match(Builder builder) {
        this.matchId = builder.matchId;
        this.profile1 = builder.profile1;
        this.profile2 = builder.profile2;
        this.status = builder.status;
    }

    public long getMatchId() {
        return matchId;
    }

    public User getProfile1() {
        return profile1;
    }

    public User getProfile2() {
        return profile2;
    }

    public MatchStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match match)) return false;
        return getMatchId() == match.getMatchId() && Objects.equals(getProfile1(), match.getProfile1()) && Objects.equals(getProfile2(), match.getProfile2()) && getStatus() == match.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatchId(), getProfile1(), getProfile2(), getStatus());
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", profile1=" + profile1 +
                ", profile2=" + profile2 +
                ", status=" + status +
                '}';
    }

    public static class Builder {
        private long matchId;
        private User profile1;
        private User profile2;
        private MatchStatus status;

        public Builder setMatchId(long matchId) {
            this.matchId = matchId;
            return this;
        }

        public Builder setProfile1(User profile1) {
            this.profile1 = profile1;
            return this;
        }

        public Builder setProfile2(User profile2) {
            this.profile2 = profile2;
            return this;
        }

        public Builder setStatus(MatchStatus status) {
            this.status = status;
            return this;
        }

        public Builder copy(Match match){
            this.matchId = match.matchId;
            this.profile1 = match.profile1;
            this.profile2 = match.profile2;
            this.status = match.status;
            return this;
        }

        public Match build() {
            return new Match(this);
        }
    }
}
