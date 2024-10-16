package za.ac.cput.domain.match;

/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import jakarta.persistence.*;
import za.ac.cput.domain.user.User;

import java.util.Objects;

// unique constraint to prevent duplicate matches.
@Entity
@Table(name = "`match`")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matchId;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private User user1Id;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private User user2Id;


    protected Match() {
    }

    protected Match(Builder builder) {
        this.matchId = builder.matchId;
        this.user1Id = builder.user1Id;
        this.user2Id = builder.user2Id;
    }

    public long getMatchId() {
        return matchId;
    }

    public User getUser1Id() {
        return user1Id;
    }

    public User getUser2Id() {
        return user2Id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match match)) return false;
        return getMatchId() == match.getMatchId() && Objects.equals(getUser1Id(), match.getUser1Id()) && Objects.equals(getUser2Id(), match.getUser2Id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatchId(), getUser1Id(), getUser2Id());
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", user1Id=" + user1Id +
                ", user2Id=" + user2Id +
                '}';
    }

    public static class Builder {
        private long matchId;
        private User user1Id;
        private User user2Id;

        public Builder setMatchId(long matchId) {
            this.matchId = matchId;
            return this;
        }

        public Builder setUser1Id(User user1Id) {
            this.user1Id = user1Id;
            return this;
        }

        public Builder setUser2Id(User user2Id) {
            this.user2Id = user2Id;
            return this;
        }



        public Builder copy(Match match){
            this.matchId = match.matchId;
            this.user1Id = match.user1Id;
            this.user2Id = match.user2Id;
            return this;
        }

        public Match build() {
            return new Match(this);
        }
    }
}
